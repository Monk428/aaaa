package com.monk.sbbook.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "t_id")
    private Long id;

    @Column(name = "t_username",nullable = false)
    private String name;

    @Column(name = "t_password",nullable = false)
    private String password;

    @Column(name = "t_salt")
    private String salt;

    @Column(name = "t_email")
    private String email;

    @Column(name = "t_mobile")
    private String mobile;

    @Column(name = "t_headUrl")
    private String headUrl;

    @Column(name = "t_role")
    private String role;

    public User(){}

    public User(String name) {
        this.name = name;
        this.password = "";
        this.salt = "";
        this.email = "";
        this.mobile = "";
        this.headUrl = "";
        this.role = "user";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
