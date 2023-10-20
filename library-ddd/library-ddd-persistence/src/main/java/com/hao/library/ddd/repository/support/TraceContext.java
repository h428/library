package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.common.Aggregate;
import com.hao.library.ddd.common.Identifier;

public interface TraceContext<T extends Aggregate<ID>, ID extends Identifier> {

    void add(ID id, T aggregate);

    T find(ID id);

    void remove(ID id);
}
