package com.hao.library.ddd.persistence.test;

import com.hao.library.ddd.types.admin.AdminId;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Order {

    private Long id;

    private String name;

    private Integer status;

    private AdminId createdBy;

    private LocalDateTime createdTime;

    private List<OrderItem> orderItems;


}
