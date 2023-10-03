package com.hao.library.ddd.types.common;

import java.time.LocalDateTime;

public class UpdateTime extends BaseDateTime {

    public UpdateTime(LocalDateTime value) {
        super(value);
    }

    public static UpdateTime now() {
        return new UpdateTime(LocalDateTime.now());
    }

}
