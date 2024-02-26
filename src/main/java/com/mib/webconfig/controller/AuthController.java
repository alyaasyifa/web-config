package com.mib.webconfig.controller;

import com.mib.webconfig.service.MasterProductCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthController {
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String productList() {
        return "list"; // Ini akan merujuk ke file list.html di folder resources/templates/
    }

    @GetMapping("/add")
    public String addProduct() {
        return "add"; // Ini akan merujuk ke file add.html di folder resources/templates/
    }
}
