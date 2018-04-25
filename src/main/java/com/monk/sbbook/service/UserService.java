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

    public User getUserByName(String name) {
        return userDao.findByUsername(name);
    }

    public User addUser(User user) {
        return userDao.save(user);
    }

    /**
     * 密码保存规则：用户密码如果直接散列后存储在数据库中，黑客可以通过获得这个密码散列值，然后通过查散列值字典（彩虹表）的方式暴力破解，得到用户的密码；通过加salt加密的方式可以一定程度上解决这一问题，因为salt值由系统随机生成，也只有系统知道。即便黑客获取了密码的散列值但在不知道salt值的前提下暴力破解散列值的几率大大降低。
     * @param username
     * @param password
     * @param mobile
     * @param email
     * @return
     */
    public Map<String, String> register(String username,
                                        String password,
                                        String mobile,
                                        String email) {
        Map<String, String> map = new HashMap<>();
        Random random = new Random();
        if (StringUtils.isEmpty(username)) {
            map.put("msg", "用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(password)) {
            map.put("msg", "密码不能为空");
            return map;
        }

        User u = userDao.findByUsername(username);
        if (u!=null) {
            map.put("msg", "用户名被占用");
            return map;
        }

        User user = new User();
        user.setUsername(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeadUrl(String.format("https://images.nowcoder.com/head/%dm.png",random.nextInt(1000)));
        user.setPassword(MD5.Generic(password+user.getSalt()));
        user.setRole("user");
        user.setEmail(email);
        user.setMobile(mobile);
        userDao.saveAndFlush(user);

        String ticket = addLoginTicket(user.getId());
        map.put("ticket",ticket);

        return map;
    }

    public Map<String,String> login(String username, String password){
        Map<String,String> map = new HashMap<>();
        if (StringUtils.isEmpty(username)){
            map.put("msg","用户名不能为空");
            return map;
        }

        if (StringUtils.isEmpty(password)){
            map.put("msg","密码不能为空");
            return map;
        }

        User u = userDao.findByUsername(username);
        if (u==null){
            map.put("msg","用户名不存在");
            return map;
        }

        if (MD5.Generic(password+u.getSalt()).equals(u.getPassword())){
            map.put("msg","密码错误");
            return map;
        }

        String ticket = addLoginTicket(u.getId());
        map.put("ticket",ticket);

        return map;
    }

    @Autowired
    private LoginTicketDao loginTicketDao;

    /**
     * @param ticket
     */
    public void logout(String ticket){
        loginTicketDao.updateTicketById(1, ticket);
    }

    /**
     * 免密登录：Cookie是web服务器存放在客户端的一个文件,客户端访问特定URL时会查询该文件，将与该URL相关的Cookie字段传输至服务端用作特定处理。Cookie可以设置失效时间，当Cookie过了失效时间后会自动消失不再随请求传输到服务器。
     * @param userId
     * @return
     */
    public String addLoginTicket(Long userId){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime()+1000*3600*30);
        loginTicket.setExpired(date);
        loginTicket.setStatus(0);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-",""));

        loginTicketDao.saveAndFlush(loginTicket);

        return loginTicket.getTicket();
    }
}