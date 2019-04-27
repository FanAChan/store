package com.achan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author AChan
 * @title: ViewController
 * @date 2019/4/16
 */
@Controller
public class ViewController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/left")
    public String left() {
        return "layui";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
