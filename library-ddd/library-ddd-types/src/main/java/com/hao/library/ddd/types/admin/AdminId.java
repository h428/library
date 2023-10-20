package com.hao.library.ddd.types.admin;

import com.hao.library.ddd.common.Identifier;

public record AdminId(int value) implements Identifier {

    @Override
    public boolean isNull() {
        return value == 0;
    }

    public static final AdminId ZERO = new AdminId(0);

}
