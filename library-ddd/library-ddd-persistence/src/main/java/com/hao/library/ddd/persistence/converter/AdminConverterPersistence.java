package com.hao.library.ddd.persistence.converter;

import com.hao.library.ddd.domain.entity.Admin;
import com.hao.library.ddd.persistence.db.AdminDO;
import com.hao.library.ddd.types.admin.AdminId;
import com.hao.library.ddd.types.admin.AdminPassword;
import com.hao.library.ddd.types.admin.AdminUsername;
import com.hao.library.ddd.types.common.CreateTime;
import com.hao.library.ddd.types.common.UpdateTime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminConverterPersistence {

    AdminConverterPersistence INSTANCE = Mappers.getMapper(AdminConverterPersistence.class);

    default Admin fromDO(AdminDO adminDO) {
        AdminId adminId = new AdminId(adminDO.getId());
        AdminUsername adminUsername = new AdminUsername(adminDO.getUsername());
        AdminPassword adminPassword = new AdminPassword(adminDO.getPassword(), adminDO.getSalt());
        CreateTime createTime = new CreateTime(adminDO.getCreateTime());
        UpdateTime updateTime = new UpdateTime(adminDO.getUpdateTime());
        return new Admin(adminId, adminUsername, adminPassword, createTime, updateTime);
    }

    default AdminDO toDO(Admin admin) {
        AdminDO adminDO = new AdminDO();
        int id = admin.getAdminId().value();
        adminDO.setId(id == 0 ? null : id);
        adminDO.setUsername(admin.getAdminUsername().value());
        adminDO.setPassword(admin.getAdminPassword().password());
        adminDO.setSalt(admin.getAdminPassword().salt());
        adminDO.setCreateTime(admin.getCreateTime().getValue());
        adminDO.setCreateTime(admin.getUpdateTime().getValue());
        return adminDO;
    }

}
