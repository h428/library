package com.hao.library.ddd.application.service;

import com.hao.library.ddd.cqe.command.AdminLoginCommand;
import com.hao.library.ddd.cqe.command.AdminUpdateUsernameCommand;
import java.util.Optional;

public interface AdminAppService {

    Optional<Integer> login(AdminLoginCommand userLoginCommand);

    void updateUsername(AdminUpdateUsernameCommand command);

}
