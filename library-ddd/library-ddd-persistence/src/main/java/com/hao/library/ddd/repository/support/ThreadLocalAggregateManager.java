package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.common.Aggregate;
import com.hao.library.ddd.common.Identifier;

public class ThreadLocalAggregateManager<T extends Aggregate<ID>, ID extends Identifier> implements AggregateTracingManager<T, ID> {

    private final ThreadLocal<DbContext<T, ID>> context;

    public ThreadLocalAggregateManager() {
        this.context = ThreadLocal.withInitial(DbContext::new);
    }

    @Override
    public void attach(T aggregate) {
        context.get().attach(aggregate);
    }

    @Override
    public void attach(T aggregate, ID id) {
        context.get().setId(aggregate, id);
        context.get().attach(aggregate);
    }


    @Override
    public void detach(T aggregate) {
        context.get().detach(aggregate);
    }

    @Override
    public T find(ID id) {
        return context.get().find(id);
    }

    @Override
    public EntityDifference detectChanges(T aggregate) {
        return context.get().detectChanges(aggregate);
    }

    @Override
    public void merge(T aggregate) {
        attach(aggregate);
    }
}
