package com.hao.library.ddd.common;

public interface Aggregate<ID extends Identifier> extends Entity<ID> {
    ID getId();
}
