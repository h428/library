package com.hao.library.ddd.persistence.test;

import com.hao.library.ddd.common.Identifier;

public record OrderItemId (Long value) implements Identifier {

    @Override
    public boolean isNull() {
        return value() == null;
    }
}
