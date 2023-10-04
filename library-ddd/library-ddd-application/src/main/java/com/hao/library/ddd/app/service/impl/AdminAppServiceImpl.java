package com.hao.library.ddd.app.service.impl;

import com.hao.library.ddd.app.cqe.command.AdminLoginCommand;
import com.hao.library.ddd.app.service.AdminAppService;
import com.hao.library.ddd.domain.entity.Admin;
import com.hao.library.ddd.repository.AdminRepository;
import com.hao.library.ddd.types.admin.AdminUsername;
import com.hao.library.ddd.types.common.InputPassword;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Admin 应用服务
 */
@Component
@AllArgsConstructor
public class AdminAppServiceImpl implements AdminAppService {

    private final AdminRepository adminRepository;

    @Override
    public Optional<Integer> login(AdminLoginCommand userLoginCommand) {

        AdminUsername adminUsername = new AdminUsername(userLoginCommand.getUsername());
        Optional<Admin> adminOptional = adminRepository.find(adminUsername);
        return adminOptional
                .filter(admin -> admin.login(new InputPassword(userLoginCommand.getPassword())))
                .map(admin -> admin.getAdminId().value());
    }
}
