package com.monk.sbbook.interceptor;

import com.monk.sbbook.dao.LoginTicketDao;
import com.monk.sbbook.dao.UserDao;
import com.monk.sbbook.entity.LoginTicket;
import com.monk.sbbook.entity.User;
import com.monk.sbbook.result.pojo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.Servlet;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.Optional;

//token访问拦截
@Component
public class PassportInterceptor implements HandlerInterceptor{
    @Autowired
    private LoginTicketDao loginTicketDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ticket = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null ) {
            for (Cookie cookie : cookies) {
                if ("ticket".equals(cookie.getName())) {
                    ticket = cookie.getValue();
                    break;
                }
            }
        }
        if (ticket!=null){
            LoginTicket loginTicket = loginTicketDao.findByTicket(ticket);
            if (loginTicket==null||loginTicket.getExpired().before(new Date())||loginTicket.getStatus()!=0){

                response.setCharacterEncoding("UTF-8");
                response.setContentType("application/json; charset=utf-8");


//                返回json
                String js = JsonResult.genFailResult("没登录").toString();
                PrintWriter out = response.getWriter();
                out.print(js);
                out.flush();
                out.close();

                return false;
            }
        }
        return true;
    }
}