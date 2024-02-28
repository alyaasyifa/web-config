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

    @GetMapping("/fragments/sidebar")
    public String sidebar() {
        return "/fragments/sidebar";
    }

    @GetMapping("/product/list-product")
    public String productList() {
        return "/product/list-product"; // Ini akan merujuk ke file list.html di folder resources/templates/
    }

    @GetMapping("/product/add-product")
    public String addProduct() {
        return "/product/add-product"; // Ini akan merujuk ke file add.html di folder resources/templates/
    }

    @GetMapping("/product/edit-product")
    public String editProduct() {
        return "/product/edit-product"; // Ini akan merujuk ke file add.html di folder resources/templates/
    }

    @GetMapping("/public/list-public")
    public String publicList() {
        return "/public/list-public"; // Ini akan merujuk ke file list.html di folder resources/templates/
    }

    @GetMapping("/public/add-public")
    public String addPublic() {
        return "/public/add-public"; // Ini akan merujuk ke file add.html di folder resources/templates/
    }

    @GetMapping("/public/edit-public")
    public String editPublic() {
        return "/public/edit-public"; // Ini akan merujuk ke file add.html di folder resources/templates/
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
