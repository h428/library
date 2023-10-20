package com.hao.library.ddd.repository.support;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;

public class DiffUtils {
    public static EntityDifference diff(Object snapshot, Object obj) {
        DiffNode diffNode = ObjectDifferBuilder.buildDefault().compare(obj, snapshot);

        if (!diffNode.hasChanges()) {
            return EntityDifference.EMPTY;
        }

        EntityDifference entityDiff = new EntityDifference();
        entityDiff.setHasChanges(true);
        diffNode.visit((node, visit) -> {
            boolean hasChanges = node.hasChanges();
            Object objValue = node.canonicalGet(obj);
            Object snapshotValue = node.canonicalGet(snapshot);
            // 处理其他的逻辑和构建 EntityDiff 对象
        });

        return entityDiff;
    }
}
