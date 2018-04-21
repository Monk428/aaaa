package com.monk.sbbook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JspController {

    @RequestMapping(value = "/jspIndex",method = RequestMethod.GET)
    public String jspIndex() {
        return "index";
    }

}
