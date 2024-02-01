package com.hao.library.ddd.web.controller;

import com.hao.library.ddd.app.cqe.command.AdminLoginCommand;
import com.hao.library.ddd.app.service.AdminAppService;
import com.hao.library.ddd.web.converter.AdminConverter;
import com.hao.library.ddd.web.ro.AdminLoginRO;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/admin")
@AllArgsConstructor
public class AdminController {

    private AdminAppService adminAppService;

    private static final AdminConverterWeb adminConverter = AdminConverterWeb.INSTANCE;

    @PostMapping("login")
    public Integer login(@RequestBody AdminLoginRO adminLoginRO) {
        AdminLoginCommand adminLoginCommand = adminConverter.roToCommand(adminLoginRO);
        Optional<Integer> optional = adminAppService.login(adminLoginCommand);
        return optional.orElse(0);
    }

}
