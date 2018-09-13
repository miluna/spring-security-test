package com.miluna.security.securitytestmiluna.repository;

import com.miluna.security.securitytestmiluna.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRepository extends JpaRepository<User, Long> {

    User getUserById(Long id);

    User getUserByName(String name);
}
