package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Multibiller;
import com.mib.webconfig.service.MultibillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Controller
public class MultibillerController {
    @Autowired
    private MultibillerService multibillerService;

    @RequestMapping(value = "/multibiller/create", method = RequestMethod.GET)
    public String showCreateForm(){
        return "multibiller/add-multibiller";
    }

    @RequestMapping(value = "/multibiller/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String,String> data) throws URISyntaxException {
        ModelAndView modelAndView = new ModelAndView();
        Multibiller multibiller = new Multibiller();
        multibiller.setName(data.get("name"));
        multibiller.setPrefix(data.get("prefix"));
        multibiller.setFee(data.get("fee"));
        multibiller.setDestinationAccount(data.get("destinationAccount"));
        multibiller.setFeeAccount(data.get("feeAccount"));
        multibillerService.create(multibiller);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("multibiller/add-multibiller");
        return modelAndView;
    }

    @RequestMapping(value = "/multibiller/list", method = RequestMethod.GET)
    public ModelAndView multibillerList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Multibiller> multibillerList = multibillerService.showAll();
        modelAndView.addObject("multibillerList", multibillerList);
        modelAndView.setViewName("multibiller/list-multibiller");
        return modelAndView;
    }

    @RequestMapping(value="/multibiller/edit/{name}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        Multibiller multibiller = multibillerService.findByName(name);
        modelAndView.addObject("multibiller", multibiller);
        modelAndView.setViewName("multibiller/edit-multibiller");
        return modelAndView;
    }

    @RequestMapping(value = "/multibiller/edit/{name}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("name") String name, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        Multibiller multibiller = new Multibiller();
        multibiller.setName(name);
        multibiller.setName(data.get("name"));
        multibiller.setPrefix(data.get("prefix"));
        multibiller.setFee(data.get("fee"));
        multibiller.setDestinationAccount(data.get("destinationAccount"));
        multibiller.setFeeAccount(data.get("feeAccount"));
        multibillerService.update(name,multibiller);
        modelAndView.setViewName("redirect:/multibiller/list");
        return modelAndView;
    }

    @RequestMapping(value = "/multibiller/delete/{name}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        multibillerService.delete(name);
        modelAndView.setViewName("redirect:/multibiller/list");
        return modelAndView;
    }
}
