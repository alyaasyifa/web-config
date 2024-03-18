package com.mib.webconfig.controller;

import com.mib.webconfig.entity.PublicKey;
import com.mib.webconfig.service.PublicKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class PublicKeyController {

    @Autowired
    private PublicKeyService publicService;


    @RequestMapping(value = "/public/list-public", method = RequestMethod.GET)
    public ModelAndView showPublicForm(){
        ModelAndView modelAndView = new ModelAndView();
        List<PublicKey> publicKeyList = publicService.showAll();
        modelAndView.addObject("publicKeyList", publicKeyList);
        modelAndView.setViewName("public/list-public");
        return modelAndView;
    }

    @RequestMapping(value = "/public/add-public", method = RequestMethod.GET)
    public ModelAndView addPublicForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("public/add-public");
        return modelAndView;
    }

    @RequestMapping(value = "/publickey/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String,String> data) {
        ModelAndView modelAndView = new ModelAndView();
        PublicKey publicKey= new PublicKey();
        publicKey.setPublickey(data.get("publickey"));
        publicKey.setName(data.get("name"));
        publicService.create(publicKey);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("public/add-public");
        return modelAndView;
    }

    @RequestMapping(value = "/public/edit/{name}", method = RequestMethod.GET)
    public ModelAndView editPublicForm(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        PublicKey publicKey = publicService.findByName(name);
        modelAndView.addObject("publickey", publicKey);
        modelAndView.setViewName("public/edit-public");
        return modelAndView;
    }

    @RequestMapping(value = "/public/delete/{name}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        publicService.delete(name);
        modelAndView.setViewName("public/list-public");
        return modelAndView;
    }
}

