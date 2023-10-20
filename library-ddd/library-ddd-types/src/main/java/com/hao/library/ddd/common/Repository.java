package com.hao.library.ddd.common;

import java.util.Optional;

public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {

    /**
     * 将一个 AggregateRoot 附属到一个Repository，让它变为可追踪。
     */
    void attach(T aggregate);

    /**
     * 解除一个 AggregateRoot 的追踪
     */
    void detach(T aggregate);

    /**
     * 保存一个 AggregateRoot
     * 保存后自动重置追踪条件
     */
    void save(T aggregate);

    /**
     * 将一个 AggregateRoot 从系统移除
     * 操作后的 Aggregate 对象自动取消追踪
     */
    void remove(T aggregate);

    /**
     * 通过 ID 寻找 AggregateRoot
     * 找到的 Aggregate 自动是可追踪的
     */
    Optional<T> find(ID id);

}
