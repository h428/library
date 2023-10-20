package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.common.Aggregate;
import com.hao.library.ddd.common.Identifier;
import java.util.HashMap;
import java.util.Map;

public class MapContext<T extends Aggregate<ID>, ID extends Identifier> implements TraceContext<T, ID> {

    private final Map<ID, T> snapshots;

    public MapContext() {
        this.snapshots = new HashMap<>();
    }

    @Override
    public void add(ID id, T aggregate) {
        T snapshot = SnapshotUtils.snapshot(aggregate);
        this.snapshots.put(aggregate.getId(), snapshot);
    }

    @Override
    public T find(ID id) {
        for (Map.Entry<ID, T> entry : this.snapshots.entrySet()) {
            ID entryId = entry.getKey();
            if (id.getClass().equals(entryId.getClass()) && entryId.value().equals(id.value())) {
                return entry.getValue();
            }
        }
        return snapshots.get(id);
    }

    @Override
    public void remove(ID id) {
        this.snapshots.remove(id);
    }
}
