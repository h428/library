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
public interface AdminConverter {

    AdminConverter INSTANCE = Mappers.getMapper(AdminConverter.class);

    default Admin fromDO(AdminDO adminDO) {
        AdminId adminId = new AdminId(adminDO.getId());
        AdminUsername adminUsername = new AdminUsername(adminDO.getUsername());
        AdminPassword adminPassword = new AdminPassword(adminDO.getPassword(), adminDO.getSalt());
        CreateTime createTime = new CreateTime(adminDO.getCreateTime());
        UpdateTime updateTime = new UpdateTime(adminDO.getUpdateTime());
        return new Admin(adminId, adminUsername, adminPassword, createTime, updateTime);
    }

}
