package com.monk.sbbook.dao;

import com.monk.sbbook.entity.LoginTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginTicketDao extends JpaRepository<LoginTicket,Long>{

    void updateStatus(String ticket, int status);

}
