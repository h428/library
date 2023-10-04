package com.hao.library.ddd.repository.impl;

import com.hao.library.ddd.cqe.query.AdminQuery;
import com.hao.library.ddd.domain.entity.Admin;
import com.hao.library.ddd.persistence.converter.AdminConverter;
import com.hao.library.ddd.persistence.db.AdminDO;
import com.hao.library.ddd.persistence.dao.AdminDao;
import com.hao.library.ddd.repository.AdminRepository;
import com.hao.library.ddd.types.admin.AdminId;
import com.hao.library.ddd.types.admin.AdminUsername;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdminRepositoryImpl implements AdminRepository {

    private final AdminDao adminDao;

    @Override
    public Optional<Admin> find(AdminUsername adminUsername) {
        Optional<AdminDO> optionalAdminDO = adminDao.findByUsername(adminUsername.value());
        return optionalAdminDO.map(AdminConverter.INSTANCE::fromDO);
    }

    @Override
    public List<Admin> query(AdminQuery adminQuery) {
        return null;
    }

    @Override
    public void save(Admin aggregate) {

    }

    @Override
    public void remove(Admin aggregate) {

    }

    @Override
    public Admin find(AdminId adminId) {
        Optional<AdminDO> adminDO = adminDao.findById(adminId.value());
        return adminDO.map(AdminConverter.INSTANCE::fromDO).orElse(null);
    }

}
