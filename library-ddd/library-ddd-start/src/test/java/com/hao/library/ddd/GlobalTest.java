package com.hao.library.ddd;

import com.hao.library.ddd.application.service.AdminAppService;
import com.hao.library.ddd.cqe.command.AdminUpdateUsernameCommand;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Rollback(value = false)
public class GlobalTest {

    @Autowired
    AdminAppService adminAppService;

    @Test
    public void test() {

        AdminUpdateUsernameCommand command = new AdminUpdateUsernameCommand();
        command.setAdminId(1111);
        command.setUsername("admin");
        this.adminAppService.updateUsername(command);


    }

}
