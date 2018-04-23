package com.monk.sbbook.dao;

import com.monk.sbbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long>{

    User findByName(String name);

}
