package com.hao.library.ddd.repository.impl;

import com.hao.library.ddd.cqe.query.AdminQuery;
import com.hao.library.ddd.domain.entity.Admin;
import com.hao.library.ddd.persistence.converter.AdminConverterPersistence;
import com.hao.library.ddd.persistence.dao.AdminDao;
import com.hao.library.ddd.persistence.db.AdminDO;
import com.hao.library.ddd.repository.AdminRepository;
import com.hao.library.ddd.repository.support.DbRepositorySupport;
import com.hao.library.ddd.repository.support.EntityDifference;
import com.hao.library.ddd.types.admin.AdminId;
import com.hao.library.ddd.types.admin.AdminUsername;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AdminRepositoryImpl extends DbRepositorySupport<Admin, AdminId> implements AdminRepository {

    private final AdminDao adminDao;

    private static final AdminConverterPersistence CONVERTER = AdminConverterPersistence.INSTANCE;

    @Override
    public Optional<Admin> find(AdminUsername adminUsername) {
        return Optional.empty();
    }

    @Override
    public List<Admin> query(AdminQuery adminQuery) {
        return null;
    }

    @Override
    protected Optional<Admin> onSelect(AdminId adminId) {
        Optional<AdminDO> adminDO = adminDao.findById(adminId.value());
        return adminDO.map(CONVERTER::fromDO);
    }

    @Override
    protected void onInsert(Admin aggregate) {

    }

    @Override
    protected void onUpdate(Admin aggregate, EntityDifference aggregateDifference) {
        // 发生变化的字段
        // 新增的字段
        // 删除的字段
    }

    @Override
    protected void onDelete(Admin aggregate) {

    }
}
