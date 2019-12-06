package com.perye.dokit.repository;

import com.perye.dokit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUsername(String username);

    User findByEmail(String email);

    @Modifying
    @Query(value = "update user set password = ?2 , last_password_reset_time = ?3 where username = ?1",nativeQuery = true)
    void updatePass(String username, String pass, Date lastPasswordResetTime);

    @Modifying
    @Query(value = "update user set email = ?2 where username = ?1",nativeQuery = true)
    void updateEmail(String username, String email);

}

