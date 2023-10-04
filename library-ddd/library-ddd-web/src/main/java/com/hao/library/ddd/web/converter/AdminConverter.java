package com.hao.library.ddd.web.converter;

import com.hao.library.ddd.app.cqe.command.AdminLoginCommand;
import com.hao.library.ddd.web.ro.AdminLoginRO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminConverter {

    AdminConverter INSTANCE = Mappers.getMapper(AdminConverter.class);

    AdminLoginCommand roToCommand(AdminLoginRO adminLoginRO);

}
