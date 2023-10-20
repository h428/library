package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.common.Aggregate;
import com.hao.library.ddd.common.Identifier;
import com.hao.library.ddd.common.Repository;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.Getter;

public abstract class DbRepositorySupport<T extends Aggregate<ID>, ID extends Identifier> implements Repository<T, ID> {

//    @Getter
//    private final Class<T> targetClass;

    @Getter(AccessLevel.PROTECTED)
    private final AggregateTracingManager<T, ID> aggregateTracingManager;

    public DbRepositorySupport() {
        this.aggregateTracingManager = new ThreadLocalAggregateManager<>();
    }

    /**
     * 由继承RepositorySupport的子类实现
     */
    protected abstract Optional<T> onSelect(ID id);
    protected abstract void onInsert(T aggregate);
    protected abstract void onUpdate(T aggregate, EntityDifference aggregateDifference);
    protected abstract void onDelete(T aggregate);

    /**
     * 主动追踪
     * @param
     * @return
     */
    public void attach(T aggregate) {
        this.aggregateTracingManager.attach(aggregate);
    }

    /**
     * 差异对比
     * @param aggregate
     * @return
     */
    protected EntityDifference different(T aggregate) {
        return this.aggregateTracingManager.detectChanges(aggregate);
    }

    /**
     * 解除追踪
     * @param
     * @return
     */
    public void detach(T aggregate) {
        this.aggregateTracingManager.detach(aggregate);
    }

    @Override
    public Optional<T> find(ID identifier) {
        Optional<T> optional = this.onSelect(identifier);
        optional.ifPresent(this.aggregateTracingManager::attach);
        return optional;
    }

    @Override
    public void save(T aggregate) {

        if (aggregate.getId() == null) {
            this.onInsert(aggregate);
            this.attach(aggregate);
            return;
        }

        EntityDifference aggregateDifference = this.aggregateTracingManager.detectChanges(aggregate);
        this.onUpdate(aggregate, aggregateDifference);
        this.aggregateTracingManager.merge(aggregate);
    }

    @Override
    public void remove(T aggregate) {
        this.onDelete(aggregate);
        this.aggregateTracingManager.detach(aggregate);
    }
}
