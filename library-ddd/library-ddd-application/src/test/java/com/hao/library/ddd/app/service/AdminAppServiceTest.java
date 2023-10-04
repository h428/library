package com.hao.library.ddd.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.hao.library.ddd.app.cqe.command.AdminLoginCommand;
import com.hao.library.ddd.app.service.impl.AdminAppServiceImpl;
import com.hao.library.ddd.domain.entity.Admin;
import com.hao.library.ddd.repository.AdminRepository;
import com.hao.library.ddd.types.admin.AdminId;
import com.hao.library.ddd.types.admin.AdminPassword;
import com.hao.library.ddd.types.admin.AdminUsername;
import com.hao.library.ddd.types.common.CreateTime;
import com.hao.library.ddd.types.common.UpdateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@DisplayName("业务服务层 AdminAppService 测试")
class AdminAppServiceTest {

    @Mock
    AdminRepository adminRepository;

    @InjectMocks
    AdminAppServiceImpl adminAppService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("测试 admin 登录")
    void login() {
        // mock
        AdminId adminId = new AdminId(124);
        AdminUsername adminUsername = new AdminUsername("admin");
        // 对应密码 admin++
        AdminPassword adminPassword = new AdminPassword(
                "5710a8cce8e6c35f95097bda5438fa8db78e83526415ae72da436ba197dde688"
                , "16b9a984f61477396624942d8e05c65caa804e4d274c6787be72ba19e0ea4035");
        Admin admin = new Admin(adminId, adminUsername, adminPassword, CreateTime.now(), UpdateTime.now());

        when(adminRepository.find(adminUsername)).thenReturn(Optional.of(admin));

        AdminLoginCommand adminLoginCommand = new AdminLoginCommand();
        adminLoginCommand.setUsername("admin");
        adminLoginCommand.setPassword("admin++");
        Optional<Integer> optional = adminAppService.login(adminLoginCommand);
        assertTrue(optional.isPresent());
        assertEquals(124, optional.get());

        AdminLoginCommand adminLoginCommand2 = new AdminLoginCommand();
        adminLoginCommand2.setUsername("admin");
        adminLoginCommand2.setPassword("admin++2");
        Optional<Integer> optional2 = adminAppService.login(adminLoginCommand2);
        assertTrue(optional2.isEmpty());

        AdminLoginCommand adminLoginCommand3 = new AdminLoginCommand();
        adminLoginCommand3.setUsername("admin333");
        adminLoginCommand3.setPassword("admin++2");
        Optional<Integer> optional3 = adminAppService.login(adminLoginCommand3);
        assertTrue(optional3.isEmpty());
    }
}