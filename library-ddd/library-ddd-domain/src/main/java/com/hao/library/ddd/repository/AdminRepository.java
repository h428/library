package com.hao.library.ddd.repository;

import com.hao.library.ddd.common.Repository;
import com.hao.library.ddd.domain.entity.Admin;
import com.hao.library.ddd.cqe.query.AdminQuery;
import com.hao.library.ddd.types.admin.AdminId;
import com.hao.library.ddd.types.admin.AdminUsername;
import java.util.List;
import java.util.Optional;

public interface AdminRepository extends Repository<Admin, AdminId> {

    Optional<Admin> find(AdminUsername adminUsername);

    List<Admin> query(AdminQuery adminQuery);

}
