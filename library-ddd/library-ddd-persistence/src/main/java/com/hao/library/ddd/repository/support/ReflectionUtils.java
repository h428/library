package com.hao.library.ddd.repository.support;

import java.lang.reflect.Field;

public class ReflectionUtils {

    public static Field[] getFields(Object obj) {
        return obj.getClass().getDeclaredFields();
    }

    public static String getFieldName(Field field) {
        return field.getName();
    }
}
