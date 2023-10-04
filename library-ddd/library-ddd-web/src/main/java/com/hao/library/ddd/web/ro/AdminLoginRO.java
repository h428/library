package com.hao.library.ddd.web.ro;

import java.io.Serializable;
import lombok.Data;

@Data
public class AdminLoginRO implements Serializable {

    private String username;
    private String password;

}
