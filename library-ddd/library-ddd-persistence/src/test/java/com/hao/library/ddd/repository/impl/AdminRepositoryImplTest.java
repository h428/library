package com.hao.library.ddd.repository.impl;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.hao.library.ddd.domain.entity.Admin;
import com.hao.library.ddd.persistence.dao.AdminDao;
import com.hao.library.ddd.persistence.db.AdminDO;
import com.hao.library.ddd.types.admin.AdminUsername;
import java.time.LocalDateTime;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@DisplayName("测试 AdminRepository")
class AdminRepositoryImplTest {

    @Mock
    private AdminDao adminDao;

    @InjectMocks
    private AdminRepositoryImpl adminRepository;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("根据 AdminUsername 查找 Admin")
    void findByUserName() {
        // mock data
        AdminDO adminDO = new AdminDO();
        adminDO.setId(123);
        adminDO.setUsername("testUsername");
        // admin++ 对应的 salt 和 password
        adminDO.setSalt("16b9a984f61477396624942d8e05c65caa804e4d274c6787be72ba19e0ea4035");
        adminDO.setPassword("5710a8cce8e6c35f95097bda5438fa8db78e83526415ae72da436ba197dde688");
        adminDO.setCreateTime(LocalDateTime.now());
        adminDO.setCreateTime(LocalDateTime.now());
        when(adminDao.findByUsername("testUsername")).thenReturn(Optional.of(adminDO));

        // test exist
        AdminUsername adminUsername = new AdminUsername("testUsername");
        Optional<Admin> result = adminRepository.find(adminUsername);
        assertTrue(result.isPresent());

        // test not exist
        AdminUsername adminUsername2 = new AdminUsername("testUsername2");
        Optional<Admin> result2 = adminRepository.find(adminUsername2);
        assertTrue(result2.isEmpty());
    }

    @Test
    void testFind() {
    }

    @Test
    void query() {
    }

    @Test
    void save() {
    }

    @Test
    void remove() {
    }

    @Test
    void testFind1() {
    }
}