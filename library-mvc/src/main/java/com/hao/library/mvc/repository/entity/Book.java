package com.hao.library.mvc.repository.entity;

import com.hao.base.common.jpa.SnowflakeIdGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", type = SnowflakeIdGenerator.class)
    private Long id;

    private String title;

    private String author;

    private String publisher;

    private LocalDate publicationDate;

    private String ISBN;

    private String summary;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Long categoryId;

}
