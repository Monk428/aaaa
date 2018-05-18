package com.monk.sbbook.controller;

import com.monk.sbbook.result.pojo.JsonResult;
import com.monk.sbbook.result.pojo.Result;
import com.monk.sbbook.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户注册管理
 */
@RestController
@RequestMapping("/verify")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result register(HttpServletResponse httpResponse,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam(required = false) String mobile,
                           @RequestParam String email) {
        Map<String,String> map = userService.register(username, password, mobile, email);
        if (map.containsKey("ticket")) {
            Cookie cookie = new Cookie("ticket",map.get("ticket"));
            cookie.setPath("/");
            httpResponse.addCookie(cookie);

            return JsonResult.genSuccessResult();
        }
        return JsonResult.genFailResult("注册失败");
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result login(HttpServletResponse httpResponse,
                        @RequestParam String username,
                        @RequestParam String password) {
        Map<String, String> map = userService.login(username, password);
        if (map.containsKey("ticket")) {
            Cookie cookie = new Cookie("ticket", map.get("ticket"));
            cookie.setPath("/");
            httpResponse.addCookie(cookie);

            return JsonResult.genSuccessResult();
        }

        return JsonResult.genFailResult("登录失败");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public Result logout(@CookieValue("ticket") String ticket) {
        userService.logout(ticket);

        return JsonResult.genSuccessResult();
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.POST)
    public Result getInfo(@CookieValue("ticket") String tick) {
        return JsonResult.genSuccessResult();
    }

}






