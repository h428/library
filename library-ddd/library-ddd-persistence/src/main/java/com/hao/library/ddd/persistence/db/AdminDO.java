package com.hao.library.ddd.persistence.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="admin")
@Data
@NoArgsConstructor
public class AdminDO {

    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
