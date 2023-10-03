package com.hao.library.ddd.types.common;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class BaseDateTime implements Serializable {

    protected LocalDateTime value;

    protected BaseDateTime(LocalDateTime value) {
        this.value = value;
    }

}
