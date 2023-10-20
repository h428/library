package com.hao.library.ddd.types.reader;

import com.hao.library.ddd.common.Identifier;

public record ReaderId(int value) implements Identifier {

    @Override
    public boolean isNull() {
        return false;
    }
}
