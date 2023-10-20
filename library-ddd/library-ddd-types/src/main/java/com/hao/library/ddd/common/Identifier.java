package com.hao.library.ddd.common;

import java.io.Serializable;

public interface Identifier extends Serializable {

    Serializable value();

    boolean isNull();

}