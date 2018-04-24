package com.monk.sbbook.dao;

import com.monk.sbbook.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserDao extends JpaRepository<User, Long>{

    User findByUsername(String username);

    //    涉及到删除或修改的要添加modifying
    @Modifying
    @Transactional
    @Query("update User u set u.username= ?1 where u.id= ?2")
    void updateUsernameById( String name, Long id);
}
