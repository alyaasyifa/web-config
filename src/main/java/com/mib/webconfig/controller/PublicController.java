package com.mib.webconfig.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicController {
    @RequestMapping(value = "/public/list-public", method = RequestMethod.GET)
    public ModelAndView showPublicForm(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("public/list-public");
        return modelAndView;
    }

    @RequestMapping(value = "/public/add-public", method = RequestMethod.GET)
    public ModelAndView addPublicForm(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("public/add-public");
        return modelAndView;
    }

    @RequestMapping(value = "/public/edit-public", method = RequestMethod.GET)
    public ModelAndView editPublicForm(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("public/edit-public");
        return modelAndView;
    }
}
