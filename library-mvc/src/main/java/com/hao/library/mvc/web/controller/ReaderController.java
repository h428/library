package com.hao.library.mvc.web.controller;

import com.hao.base.common.bean.PageBean;
import com.hao.base.common.bean.Res;
import com.hao.base.common.query.PageQuery;
import com.hao.library.mvc.repository.entity.Reader;
import com.hao.library.mvc.web.ro.ReaderSaveRO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reader")
public class ReaderController {

    @PostMapping("save")
    public Res<Void> save(@RequestBody ReaderSaveRO readerSaveRO) {
        return Res.success();
    }

    @GetMapping("findById/{id}")
    public Res<Reader> findById(@PathVariable Long id) {
        return Res.success();
    }

    @GetMapping("find")
    public Res<PageBean<Reader>> find(PageQuery pageQuery) {
        return Res.success();
    }

}
