package com.hao.library.ddd.application.service.impl;

import com.hao.library.ddd.cqe.command.AdminLoginCommand;
import com.hao.library.ddd.application.service.AdminAppService;
import com.hao.library.ddd.cqe.command.AdminUpdateUsernameCommand;
import com.hao.library.ddd.domain.entity.Admin;
import com.hao.library.ddd.repository.AdminRepository;
import com.hao.library.ddd.types.admin.AdminId;
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

    @Override
    public void updateUsername(AdminUpdateUsernameCommand command) {
        Integer adminId = command.getAdminId();
        Optional<Admin> adminOptional = adminRepository.find(new AdminId(adminId));
        AdminUsername adminUsername = new AdminUsername(command.getUsername());
        adminOptional.ifPresent(admin -> {
            admin.update(adminUsername);
            adminRepository.save(admin);
        });
    }
}
