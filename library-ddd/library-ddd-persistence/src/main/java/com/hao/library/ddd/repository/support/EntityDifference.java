package com.hao.library.ddd.repository.support;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntityDifference {

    public static final EntityDifference EMPTY = new EntityDifference();

    private boolean hasChanges;

    private EntityDifferenceType type;

    // 省略其余属性的实现

    public EntityDifference() {

    }
}
