package com.hao.library.ddd.types.common;

import java.time.LocalDateTime;

public class CreateTime extends BaseDateTime {

    public CreateTime(LocalDateTime value) {
        super(value);
    }

    public static CreateTime now() {
        return new CreateTime(LocalDateTime.now());
    }

}
