package com.monk.sbbook.dao;

import com.monk.sbbook.entity.LoginTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * Token验证jpa接口
 */
public interface LoginTicketDao extends JpaRepository<LoginTicket, Long>{

    LoginTicket findByTicket(String ticket);

//    涉及到删除或修改的要添加modifying
//    用于退出登录
    @Modifying
    @Transactional
    @Query("update LoginTicket u set u.status=?1 where u.ticket=?2")
    int updateStatusByTicket(int status, String ticket);

//    如果登录失败后，需要把ticket置为退出
    @Modifying
    @Transactional
    @Query("update LoginTicket u set u.status=?1 where u.userId=?2")
    void updateStatusByUserId(int status, Long userId);

}
