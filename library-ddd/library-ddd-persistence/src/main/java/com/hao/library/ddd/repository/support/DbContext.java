package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.common.Aggregate;
import com.hao.library.ddd.common.Identifier;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

public class DbContext<T extends Aggregate<ID>, ID extends Identifier> {

    @Getter
    private Class<? extends T> aggregateClass;

    private Map<ID, T> aggregateMap = new HashMap<>();

    public DbContext(Class<? extends T> aggregateClass) {
        this.aggregateClass = aggregateClass;
    }

    public DbContext() {

    }

    public void attach(T aggregate) {
        if (aggregate.getId() != null) {
            if (!aggregateMap.containsKey(aggregate.getId())) {
                this.merge(aggregate);
            }
        }
    }

    public void detach(T aggregate) {
        if (aggregate.getId() != null) {
            aggregateMap.remove(aggregate.getId());
        }
    }

    /**
     * update 时检测聚合根变化
     *
     * @param aggregate 聚合根
     * @return 聚合根变化
     */
    public EntityDifference detectChanges(T aggregate) {
        assert aggregate != null;
        assert !aggregate.getId().isNull();

        T snapshot = aggregateMap.get(aggregate.getId());
        assert snapshot != null;

        return DiffUtils.diff(snapshot, aggregate);
    }

    public T find(ID id) {
        return aggregateMap.get(id);
    }

    public void merge(T aggregate) {
        if (aggregate.getId() != null) {
            T snapshot = SnapshotUtils.snapshot(aggregate); // 拷贝一份快照
            aggregateMap.put(aggregate.getId(), snapshot); // 将快照放入缓存
        }
    }

    public void setId(T aggregate, ID id) {
//        ReflectionUtils.writeField("id", aggregate, id);
    }
}
