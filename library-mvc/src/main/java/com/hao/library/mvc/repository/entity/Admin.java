package com.hao.library.mvc.repository.entity;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.hao.base.common.jpa.SnowflakeIdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", type = SnowflakeIdGenerator.class)
    private Long id;

    private String username;

    private String password;

    private String salt;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    public boolean login(String inputPassword) {
        String out = SecureUtil.sha256(inputPassword + salt);
        return out.equals(password);
    }

    public void resetPassword(String inputPassword) {
        this.salt = SecureUtil.sha256(IdUtil.fastSimpleUUID());
        this.password = SecureUtil.sha256(inputPassword + salt);
    }

}
