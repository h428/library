package com.hao.library.ddd.app.cqe.command;

import java.io.Serializable;
import lombok.Data;

@Data
public class AdminLoginCommand implements Serializable {
    private String username;
    private String password;
}
