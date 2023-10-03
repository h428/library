package com.hao.library.ddd.domain.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.hao.library.ddd.types.admin.AdminPassword;
import com.hao.library.ddd.types.admin.AdminUsername;
import com.hao.library.ddd.types.common.InputPassword;
import org.junit.jupiter.api.Test;

class AdminTest {

    @Test
    void login() {
        AdminUsername adminUsername = new AdminUsername("lyh");
        String pass = "lyh";
        AdminPassword adminPassword = AdminPassword.generateBasedOn(new InputPassword(pass));
        Admin admin = Admin.of(adminUsername, adminPassword);
        assertTrue(admin.login(new InputPassword("lyh")));
        assertFalse(admin.login(new InputPassword("lyh2")));
    }
}