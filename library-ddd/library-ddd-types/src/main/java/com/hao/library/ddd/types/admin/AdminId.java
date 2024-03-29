package com.hao.library.ddd.types.admin;

import com.hao.library.ddd.common.Identifier;

public record AdminId(Integer value) implements Identifier {

    public static final AdminId ZERO = new AdminId(0);
    public static final AdminId NULL = new AdminId(null);

    @Override
    public boolean isNull() {
        return false;
    }
}
