package com.mib.webconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @RequestMapping(value = "/product/list-product", method = RequestMethod.GET)
    public ModelAndView showProductForm(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("product/list-product");
        return modelAndView;
    }

    @RequestMapping(value = "/product/add-product", method = RequestMethod.GET)
    public ModelAndView addProductForm(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("product/add-product");
        return modelAndView;
    }

    @RequestMapping(value = "/product/edit-product", method = RequestMethod.GET)
    public ModelAndView editProductForm(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("product/edit-product");
        return modelAndView;
    }
}
