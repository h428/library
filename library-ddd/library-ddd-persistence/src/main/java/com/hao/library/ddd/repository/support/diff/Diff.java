package com.hao.library.ddd.repository.support.diff;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@SuppressWarnings("unchecked")
public class Diff {

    private Object oldValue;
    private Object newValue;
    @Getter
    private DiffType type;

    public static Diff add(Object newValue) {
        return new Diff(null, newValue, com.hao.library.ddd.repository.support.diff.DiffType.ADD);
    }

    public static Diff remove(Object oldValue) {
        return new Diff(oldValue, null, com.hao.library.ddd.repository.support.diff.DiffType.REMOVE);
    }

    public static Diff modify(Object oldValue, Object newValue) {
        return new Diff(oldValue, newValue, com.hao.library.ddd.repository.support.diff.DiffType.MODIFY);
    }

    public <T> T getOldValue() {
        return (T) oldValue;
    }

    public <T> T getNewValue() {
        return (T) newValue;
    }
}
