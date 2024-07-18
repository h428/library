package com.hao.library.mvc.service;

import com.hao.library.mvc.repository.dao.AdminDao;
import com.hao.library.mvc.repository.entity.Admin;
import com.hao.library.mvc.web.ro.AdminLoginRO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminService {

    private AdminDao adminDao;

    public boolean login(AdminLoginRO adminLoginRO) {
        String username = adminLoginRO.getUsername();
        String password = adminLoginRO.getPassword();

        Admin admin = this.adminDao.findByUsername(username);

        if (admin == null) {
            return false;
        }

        return admin.login(password);
    }

    public Admin findById(Long id) {
        return adminDao.getReferenceById(id);
    }


}
