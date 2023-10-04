package com.hao.library.ddd.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.hao.library.ddd.app.cqe.command.AdminLoginCommand;
import com.hao.library.ddd.app.service.AdminAppService;
import com.hao.library.ddd.web.ro.AdminLoginRO;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class AdminControllerTest {


    @Mock
    private AdminAppService adminAppService;

    @InjectMocks
    private AdminController adminController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login() {

        AdminLoginCommand command = new AdminLoginCommand();
        command.setUsername("admin");
        command.setPassword("admin++");
        when(adminAppService.login(command)).thenReturn(Optional.of(1));

        AdminLoginRO inputRo = new AdminLoginRO();
        inputRo.setUsername("admin");
        inputRo.setPassword("admin++");
        assertEquals(1, adminController.login(inputRo));

        AdminLoginRO inputRo2 = new AdminLoginRO();
        inputRo2.setUsername("admin");
        inputRo2.setPassword("admin--");
        assertEquals(0, adminController.login(inputRo2));

        AdminLoginRO inputRo3 = new AdminLoginRO();
        inputRo2.setUsername("admin232");
        inputRo2.setPassword("admindsafdsa");
        assertEquals(0, adminController.login(inputRo3));

    }
}