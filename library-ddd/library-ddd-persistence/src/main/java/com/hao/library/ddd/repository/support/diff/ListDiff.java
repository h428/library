package com.hao.library.ddd.repository.support.diff;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ListDiff {

    private List<Diff> diffList = new ArrayList<>();

    public ListDiff() {
    }

    // 添加一项不同
    public void add(Diff diff) {
        diffList.add(diff);
    }

}
