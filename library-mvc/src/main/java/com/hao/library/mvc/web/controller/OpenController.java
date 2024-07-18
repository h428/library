package com.hao.library.mvc.web.controller;

import com.hao.base.common.pojo.wrapper.Res;
import com.hao.library.mvc.service.AdminService;
import com.hao.library.mvc.web.ro.AdminLoginRO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("open")
@AllArgsConstructor
public class OpenController {

    private AdminService adminService;

    @PostMapping("adminLogin")
    public Res<String> adminLogin(@RequestBody AdminLoginRO adminLoginRO) {
        if (this.adminService.login(adminLoginRO)) {
            return Res.success();
        }
        return Res.errorParam();
    }

}
