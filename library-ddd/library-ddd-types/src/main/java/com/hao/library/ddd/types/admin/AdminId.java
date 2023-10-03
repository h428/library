package com.hao.library.ddd.types.admin;

import com.hao.library.ddd.common.Identifier;

public record AdminId(int value) implements Identifier {

    public static final AdminId ZERO = new AdminId(0);

}
