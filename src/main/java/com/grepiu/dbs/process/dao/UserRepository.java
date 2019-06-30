package com.grepiu.dbs.process.dao;

import com.grepiu.dbs.process.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
