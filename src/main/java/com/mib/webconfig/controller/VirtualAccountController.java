package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Multibiller;
import com.mib.webconfig.entity.VirtualAccount;
import com.mib.webconfig.service.VirtualAccountService;
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
public class VirtualAccountController {

    @Autowired
    private VirtualAccountService virtualAccountService;



    @RequestMapping(value = "/virtualaccount/create", method = RequestMethod.GET)
    public ModelAndView addVirtualaccountForm(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("virtualaccount/add-virtualaccount");
        return modelAndView;
    }

    @RequestMapping(value = "/virtualaccount/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String,String> data)  {
        ModelAndView modelAndView = new ModelAndView();
        VirtualAccount virtualaccount= new VirtualAccount();
        virtualaccount.setName(data.get("name"));
        virtualaccount.setPrefix(data.get("prefix"));
        virtualaccount.setFee(data.get("fee"));
        virtualaccount.setDestinationAccount(data.get("destinationAccount"));
        virtualaccount.setFeeAccount(data.get("feeAccount"));
        virtualAccountService.create(virtualaccount);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("virtualaccount/add-virtualaccount");
        return modelAndView;
    }

    @RequestMapping(value = "/virtualaccount/list", method = RequestMethod.GET)
    public ModelAndView virtualAccountList(){
        ModelAndView modelAndView = new ModelAndView();
        List<VirtualAccount> virtualaccountList = virtualAccountService.showAll();
        modelAndView.addObject("virtualaccountList", virtualaccountList);
        modelAndView.setViewName("virtualaccount/list-virtualaccount");
        return modelAndView;
    }
    @RequestMapping(value = "/virtualaccount/edit/{name}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        VirtualAccount virtualaccount = virtualAccountService.findByName(name);
        modelAndView.addObject("virtualaccount", virtualaccount);
        modelAndView.setViewName("virtualaccount/edit-virtualaccount");
        return modelAndView;
    }


    @RequestMapping(value = "/virtualaccount/edit/{name}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("name") String name, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        VirtualAccount virtualAccount = new VirtualAccount();
        virtualAccount.setName(name);
        virtualAccount.setName(data.get("name"));
        virtualAccount.setPrefix(data.get("prefix"));
        virtualAccount.setFee(data.get("fee"));
        virtualAccount.setDestinationAccount(data.get("destinationAccount"));
        virtualAccount.setFeeAccount(data.get("feeAccount"));
        virtualAccountService.update(name,virtualAccount);
        modelAndView.setViewName("redirect:/virtualaccount/list");
        return modelAndView;
    }


    @RequestMapping(value = "/virtualaccount/delete/{name}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("name") String name){
        ModelAndView modelAndView = new ModelAndView();
        virtualAccountService.delete(name);
        modelAndView.setViewName("redirect:/virtualaccount/list");
        return modelAndView;
    }
}
