package com.monk.sbbook.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LoginTicket {
//    @Id
//    @GeneratedValue
//    @Column(name = "t_id")
//    private Long id;

//    将这个值作为主键，否则每次save都重新创建了
    @Id
    @Column(name = "t_userid")
    private Long userId;

    @Column(name = "t_expired")
    private Date expired;

    @Column(name = "t_status")
    private int status;

    @Column(name = "t_ticket")
    private String ticket;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}
