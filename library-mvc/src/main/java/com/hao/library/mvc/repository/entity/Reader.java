package com.hao.library.mvc.repository.entity;

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
public class Reader {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", type = SnowflakeIdGenerator.class)
    private Long id;

    private String username;

    private String password;

    private String email;

    private Integer maxBorrowNum;

    private Integer state;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
