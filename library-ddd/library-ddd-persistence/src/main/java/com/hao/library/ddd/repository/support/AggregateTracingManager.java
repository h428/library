package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.common.Aggregate;
import com.hao.library.ddd.common.Identifier;

public interface AggregateTracingManager<T extends Aggregate<ID>, ID extends Identifier> {

    /**
     * 变更追踪
     * @param aggregate 聚合根
     */
    void attach(T aggregate);

    void attach(T aggregate, ID id);

    /**
     * 解除追踪
     * @param aggregate 聚合根
     */
    void detach(T aggregate);

    /**
     * 对比差异
     * @param aggregate 聚合根
     * @return
     */
    EntityDifference detectChanges(T aggregate) ;

    /**
     * 合并变更
     * @param aggregate 聚合根
     */
    void merge(T aggregate);

    T find(ID id);
}
