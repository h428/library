package com.hao.library.ddd.cqe.command;

import java.io.Serializable;
import lombok.Data;

@Data
public class AdminUpdateUsernameCommand implements Serializable {
    private Integer adminId;
    private String username;
}
