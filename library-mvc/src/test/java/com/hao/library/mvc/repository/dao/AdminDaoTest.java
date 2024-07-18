package com.hao.library.mvc.repository.dao;

import com.hao.library.mvc.LibraryTest;
import com.hao.library.mvc.repository.entity.Admin;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;


public class AdminDaoTest extends LibraryTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    @Rollback(value = false)
    public void init() {

        LocalDateTime now = LocalDateTime.now();

        Admin admin = new Admin();
        admin.setUsername("admin");
        admin.resetPassword("admin");
        admin.setCreateTime(now);
        admin.setUpdateTime(now);

        adminDao.save(admin);
    }

}