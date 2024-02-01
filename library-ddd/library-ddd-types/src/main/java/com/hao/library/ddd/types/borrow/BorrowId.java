package com.hao.library.ddd.types.borrow;

import com.hao.library.ddd.common.Identifier;

public record BorrowId(Integer value) implements Identifier {

    @Override
    public boolean isNull() {
        return false;
    }
}
