package com.monk.sbbook.service;

import com.monk.sbbook.dao.LoginTicketDao;
import com.monk.sbbook.dao.UserDao;
import com.monk.sbbook.entity.LoginTicket;
import com.monk.sbbook.entity.User;
import com.monk.sbbook.utils.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginTicketDao loginTicketDao;

//    public User getUserByName(String name) {
//        return userDao.findByUsername(name);
//    }

//    public User addUser(User user) {
//        return userDao.save(user);
//    }

//    public Map<String, String> register(String username,
//                                        String password,
//                                        String mobile,
//                                        String email) {
//        Map<String, String> map = new HashMap<>();
//        Random random = new Random();
//        if (StringUtils.isEmpty(username)) {
//            map.put("msg", "用户名不能为空");
//            return map;
//        }
//
//        if (StringUtils.isEmpty(password)) {
//            map.put("msg", "密码不能为空");
//            return map;
//        }
//
//        User u = userDao.findByUsername(username);
//        if (u!=null) {
//            map.put("msg", "用户名被占用");
//            return map;
//        }
//
//        User user = new User();
//        user.setUsername(username);
//        user.setSalt(UUID.randomUUID().toString().substring(0,5));
//        user.setHeadUrl(String.format("https://images.nowcoder.com/head/%dm.png",random.nextInt(1000)));
//        user.setPassword(MD5.Generic(password+user.getSalt()));
//        user.setRole("user");
//        user.setEmail(email);
//        user.setMobile(mobile);
//        userDao.save(user);
//
//        String ticket = addLoginTicket(user.getId());
//        map.put("ticket",ticket);
//
//        return map;
//    }

//    public Map<String,String> login(String username, String password){
//        Map<String,String> map = new HashMap<>();
//        if (StringUtils.isEmpty(username)){
//            map.put("msg","用户名不能为空");
//            return map;
//        }
//
//        if (StringUtils.isEmpty(password)){
//            map.put("msg","密码不能为空");
//            return map;
//        }
//
//        User u = userDao.findByUsername(username);
//        if (u==null){
//            map.put("msg","用户名不存在");
//            return map;
//        }
//
//        if (MD5.Generic(password+u.getSalt()).equals(u.getPassword())){
//            map.put("msg","密码错误");
//            return map;
//        }
//
//        String ticket = addLoginTicket(u.getId());
//        map.put("ticket",ticket);
//
//        return map;
//    }

//    public void logout(String ticket){
//        loginTicketDao.updateStatus(ticket,1);
//    }

    public String addLoginTicket(Long userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*30);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));

        loginTicketDao.save(loginTicket);

        return loginTicket.getTicket();
    }
}