package com.hao.library.mvc.service;

import static org.junit.jupiter.api.Assertions.*;

import com.hao.library.mvc.LibraryTest;
import com.hao.library.mvc.web.ro.AdminLoginRO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class AdminServiceTest extends LibraryTest {

    @Autowired
    private AdminService adminService;

    @Test
    void login() {
        AdminLoginRO adminLoginRO = new AdminLoginRO();
        adminLoginRO.setUsername("admin");
        adminLoginRO.setPassword("admin");
        assertTrue(this.adminService.login(adminLoginRO));
    }

    @Test
    void findById() {
    }
}