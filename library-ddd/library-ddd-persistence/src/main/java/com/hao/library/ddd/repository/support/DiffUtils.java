package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.persistence.test.Order;
import com.hao.library.ddd.persistence.test.OrderItem;
import com.hao.library.ddd.persistence.test.OrderItemId;
import com.hao.library.ddd.repository.support.diff.Diff;
import com.hao.library.ddd.repository.support.diff.DiffType;
import com.hao.library.ddd.repository.support.diff.ListDiff;
import com.hao.library.ddd.types.admin.AdminId;
import de.danielbechler.diff.ObjectDiffer;
import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import de.danielbechler.diff.path.NodePath;
import java.util.List;

public class DiffUtils {

    private static final ObjectDiffer differ = ObjectDifferBuilder.buildDefault();

    public static EntityDifference diff(Object snapshot, Object obj) {
        DiffNode root = differ.compare(obj, snapshot);

        if (!root.hasChanges()) {
            return EntityDifference.EMPTY;
        }

        EntityDifference entityDiff = new EntityDifference();
        entityDiff.setHasChanges(true);
        root.visit((node, visit) -> {

            if (!node.hasChanges() || node.isRootNode()) {
                return;
            }

            Class<?> type = node.getValueType();

            if (type.getCanonicalName().startsWith("java.lang") && !node.getParentNode().isRootNode()) {
                return;
            }

            System.out.println(node);

            // 获取差异的属性路径
            String propertyPath = node.getPropertyName();

            NodePath path = node.getPath();

            // 获取两个对象在这个节点的值
            Object oldValue = node.canonicalGet(snapshot);
            Object newValue = node.canonicalGet(obj);

//                if (node.hasChildren()) {
//                    ListDiff listDiff = new ListDiff();
//                    entityDiff.addListDiff(propertyPath, listDiff);
//                    return;
//                }

            // 打印差异信息
            System.out.println("Changed property: " + propertyPath);
            System.out.println("Old value: " + oldValue);
            System.out.println("New value: " + newValue);
            System.out.println();

        });

        return entityDiff;
    }

    static void test(EntityDifference entityDifference) {
        ListDiff lineItemDiffs = entityDifference.getListDiff("orderItems");
        for (Diff itemDiff : lineItemDiffs.getDiffList()) {
            if (itemDiff.getType() == DiffType.REMOVE) {
                OrderItem line = itemDiff.getOldValue();
                System.out.println("删除了" + line);
            }
            if (itemDiff.getType() == DiffType.ADD) {
                OrderItem line = itemDiff.getNewValue();
                System.out.println("新增了" + line);
            }
            if (itemDiff.getType() == DiffType.MODIFY) {
                OrderItem line = itemDiff.getNewValue();
                System.out.println("修改了" + line);
            }
        }

    }

    public static void main(String[] args) {
        Order snap = new Order();
        snap.setId(1L);
        snap.setName("order");
        snap.setStatus(1);
        snap.setCreatedBy(new AdminId(1));
        List<OrderItem> orderItems = List.of(new OrderItem(new OrderItemId(1L).value(), 1L, 1, 1, 1),
                new OrderItem(new OrderItemId(2L).value(), 1L, 2, 2, 1));
        snap.setOrderItems(orderItems);

        Order order = new Order();
        order.setId(1L);
        order.setName("order2");
        order.setStatus(2);
        order.setCreatedBy(new AdminId(1));
        List<OrderItem> snapshotOrderItems = List.of(new OrderItem(new OrderItemId(1L).value(), 1L, 2, 1, 1),
                new OrderItem(new OrderItemId(2L).value(), 1L, 2, 2, 1));
        order.setOrderItems(snapshotOrderItems);

        EntityDifference diff = diff(snap, order);
//        test(diff);

    }
}
