package com.mib.webconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/fragments/sidebar")
    public String sidebar() {
        return "/fragments/sidebar";
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Ini akan merujuk ke file add.html di folder resources/templates/
    }

    @GetMapping("/register")
    public String register() {
        return "register"; // Ini akan merujuk ke file add.html di folder resources/templates/
    }
}
