package com.hao.library.ddd.types.admin;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.hao.library.ddd.types.common.InputPassword;
import java.io.Serializable;

public record AdminPassword(String salt, String password) implements Serializable {

    public AdminPassword {
        Assert.equals(64, salt.length());
        Assert.equals(64, password.length());
    }

    public static AdminPassword generateBasedOn(InputPassword inputPassword) {
        String salt = SecureUtil.sha256(IdUtil.fastSimpleUUID());
        String password = DigestUtil.sha256Hex(inputPassword.value() + salt);
        return new AdminPassword(salt, password);
    }


    public boolean loginWith(InputPassword inputPassword) {
        String generatePassword = DigestUtil.sha256Hex(inputPassword.value() + salt);
        return password.equals(generatePassword);
    }
}
