package com.hao.library.ddd.domain.entity;

import cn.hutool.core.lang.Assert;
import com.hao.library.ddd.common.Aggregate;
import com.hao.library.ddd.types.admin.AdminId;
import com.hao.library.ddd.types.admin.AdminPassword;
import com.hao.library.ddd.types.admin.AdminUsername;
import com.hao.library.ddd.types.common.CreateTime;
import com.hao.library.ddd.types.common.InputPassword;
import com.hao.library.ddd.types.common.UpdateTime;
import lombok.Getter;

@Getter
public class Admin implements Aggregate<AdminId> {

    private AdminId adminId;
    private AdminUsername adminUsername;
    private AdminPassword adminPassword;
    private CreateTime createTime;
    private UpdateTime updateTime;

    public Admin(AdminId adminId, AdminUsername adminUsername, AdminPassword adminPassword,
            CreateTime createTime, UpdateTime updateTime) {
        Assert.isTrue(adminId.value() >= 0);
        Assert.notNull(adminUsername);
        Assert.notNull(adminPassword);
        Assert.notNull(createTime);
        Assert.notNull(updateTime);

        this.adminId = adminId;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public static Admin of(AdminUsername adminUsername, AdminPassword adminPassword) {
        CreateTime createTime = CreateTime.now();
        UpdateTime updateTime = UpdateTime.now();
        return new Admin(AdminId.ZERO, adminUsername, adminPassword, createTime, updateTime);
    }

    public boolean login(InputPassword inputPassword) {
        return adminPassword.loginWith(inputPassword);
    }

    public Admin update(AdminUsername adminUsername) {
        this.adminUsername = adminUsername;
        this.updateTime = UpdateTime.now();
        return this;
    }

    public Admin update(InputPassword inputPassword) {
        this.adminPassword = AdminPassword.generateBasedOn(inputPassword);
        return this;
    }

}
