package com.linn.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2018-02-07.
 */
@Controller
public class LoginController {

    @RequestMapping("/admin")
    private String toLogin() throws Exception {


        return "admin/index";
    }
}