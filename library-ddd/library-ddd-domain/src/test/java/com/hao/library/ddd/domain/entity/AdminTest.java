package com.hao.library.ddd.domain.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hao.library.ddd.types.admin.AdminPassword;
import com.hao.library.ddd.types.admin.AdminUsername;
import com.hao.library.ddd.types.common.InputPassword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("用户实体类测试")
class AdminTest {

    @Test
    @DisplayName("测试用户登录")
    void login() {
        AdminUsername adminUsername = new AdminUsername("admin");
        String pass = "admin123++";
        AdminPassword adminPassword = AdminPassword.generateBasedOn(new InputPassword(pass));
        Admin admin = Admin.of(adminUsername, adminPassword);
        assertTrue(admin.login(new InputPassword("admin123++")));
        assertFalse(admin.login(new InputPassword("admin12++")));
    }
}