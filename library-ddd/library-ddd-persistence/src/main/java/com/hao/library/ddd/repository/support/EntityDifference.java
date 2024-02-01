package com.hao.library.ddd.repository.support;

import com.hao.library.ddd.repository.support.diff.Diff;
import com.hao.library.ddd.repository.support.diff.ListDiff;
import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class EntityDifference {

    public static final EntityDifference EMPTY = new EntityDifference();

    private boolean hasChanges;

    private Map<String, Diff> diffMap = new HashMap<>();

    private Map<String, ListDiff> listDiffMap = new HashMap<>();

    public Diff getDiff(String key) {
        return diffMap.get(key);
    }

    public ListDiff getListDiff(String key) {
        return listDiffMap.get(key);
    }

    public void addListDiff(String key, ListDiff listDiff) {
        listDiffMap.put(key, listDiff);
    }

}
