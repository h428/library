package com.hao.library.mvc.web.controller;

import com.hao.base.common.pojo.query.PageQuery;
import com.hao.base.common.pojo.wrapper.Page;
import com.hao.base.common.pojo.wrapper.Res;
import com.hao.library.mvc.repository.entity.Admin;
import com.hao.library.mvc.repository.entity.Reader;
import com.hao.library.mvc.web.ro.AdminSaveRO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin")
public class AdminController {

    @PostMapping("save")
    public Res<Void> save(@RequestBody AdminSaveRO adminSaveRO) {
        return Res.success();
    }

    @GetMapping("findById/{id}")
    public Res<Admin> findById(@PathVariable Long id) {
        return Res.success();
    }

    @GetMapping("find")
    public Res<Page<Reader>> find(PageQuery pageQuery) {
        return Res.success();
    }

}
