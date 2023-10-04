package com.hao.library.ddd.app.service;

import com.hao.library.ddd.app.cqe.command.AdminLoginCommand;
import java.util.Optional;

public interface AdminAppService {

    Optional<Integer> login(AdminLoginCommand userLoginCommand);

}
