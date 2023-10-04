package com.hao.library.ddd.types.admin;

import static org.junit.jupiter.api.Assertions.*;

import com.hao.library.ddd.types.common.InputPassword;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("用户密码测试")
class AdminPasswordTest {

    @Test
    @DisplayName("合并测试生成 salt, password 以及对应的登录功能")
    void generateAndLogin() {
        String pass = "admin++";
        AdminPassword adminPassword = AdminPassword.generateBasedOn(new InputPassword(pass));
        assertTrue(adminPassword.loginWith(new InputPassword(pass)));
        assertFalse(adminPassword.loginWith(new InputPassword("admin--")));
    }

}