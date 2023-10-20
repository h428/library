package com.hao.library.ddd.types.category;

import com.hao.library.ddd.common.Identifier;

public record CategoryId(int value) implements Identifier {

    @Override
    public boolean isNull() {
        return false;
    }
}
