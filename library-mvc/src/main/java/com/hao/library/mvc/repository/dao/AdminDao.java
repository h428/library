package com.hao.library.mvc.repository.dao;

import com.hao.base.common.jpa.BaseDao;
import com.hao.library.mvc.repository.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends BaseDao<Admin, Long> {

    Admin findByUsername(String username);

}
