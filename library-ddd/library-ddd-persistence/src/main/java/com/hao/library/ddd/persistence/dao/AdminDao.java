package com.hao.library.ddd.persistence.dao;

import com.hao.library.ddd.persistence.db.AdminDO;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<AdminDO, Integer> {

    Optional<AdminDO> findByUsername(String username);

}
