package com.hao.library.ddd.web.converter;

import com.hao.library.ddd.cqe.command.AdminLoginCommand;
import com.hao.library.ddd.web.ro.AdminLoginRO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AdminConverterWeb {

    AdminConverterWeb INSTANCE = Mappers.getMapper(AdminConverterWeb.class);

    AdminLoginCommand roToCommand(AdminLoginRO adminLoginRO);

}
