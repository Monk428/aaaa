package com.monk.sbbook.dao;

import com.monk.sbbook.entity.LoginTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LoginTicketDao extends JpaRepository<LoginTicket, Long>{

//    涉及到删除或修改的要添加modifying
    @Modifying
    @Query("update LoginTicket u set u.ticket=?1,u.status=?2 where u.id=?3")
    int updateTicketById( String ticket, int status, Long id);

}
