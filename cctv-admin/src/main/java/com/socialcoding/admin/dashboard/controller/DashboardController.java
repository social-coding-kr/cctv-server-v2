package com.socialcoding.admin.dashboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DashboardController {

    @RequestMapping(path = { "/", "/dashboard"}, method = RequestMethod.GET)
    public String dashboard() {
        return "index";
    }
}

