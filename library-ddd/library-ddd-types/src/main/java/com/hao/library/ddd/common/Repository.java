package com.hao.library.ddd.common;

public interface Repository<T extends Aggregate<ID>, ID extends Identifier> {

//    /**
//     * 将一个Aggregate附属到一个Repository，让它变为可追踪。
//     * Change-Tracking在下文会讲，非必须
//     */
//    void attach(@NotNull T aggregate);
//
//    /**
//     * 解除一个Aggregate的追踪
//     * Change-Tracking在下文会讲，非必须
//     */
//    void detach(@NotNull T aggregate);

    /**
     * 保存一个 Aggregate
     * 保存后自动重置追踪条件
     */
    void save(T aggregate);

    /**
     * 将一个 Aggregate 从 Repository 移除
     * 操作后的 Aggregate 对象自动取消追踪
     */
    void remove(T aggregate);

    /**
     * 通过 ID 寻找 Aggregate。
     * 找到的 Aggregate 自动是可追踪的
     */
    T find(ID id);

}
