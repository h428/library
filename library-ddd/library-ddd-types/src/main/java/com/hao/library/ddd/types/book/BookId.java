package com.hao.library.ddd.types.book;

import com.hao.library.ddd.common.Identifier;

public record BookId(Integer value) implements Identifier {

    @Override
    public boolean isNull() {
        return false;
    }
}
