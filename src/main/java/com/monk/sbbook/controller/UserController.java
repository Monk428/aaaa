package com.monk.sbbook.controller;

import com.monk.sbbook.entity.User;
import com.monk.sbbook.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userJPA.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public User save(User user) {
        return userJPA.save(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public List<User> delete(Long id) {
        userJPA.deleteById(id);
        return userJPA.findAll();
    }

}
