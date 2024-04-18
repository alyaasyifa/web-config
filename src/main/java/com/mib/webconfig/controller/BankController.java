package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Bank;
import com.mib.webconfig.service.BankService;
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
public class BankController {
    @Autowired
    private BankService bankService;

    @RequestMapping(value = "/bank/create", method = RequestMethod.GET)
    public String showCreateFrom() { return "bank/add-bank"; }

    @RequestMapping(value = "/bank/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String, String> data) throws URISyntaxException {
        ModelAndView modelAndView = new ModelAndView();
        Bank bank = new Bank();
        bank.setBankCode(data.get("bankCode"));
        bank.setBankName(data.get("bankName"));
        bank.setBin(data.get("bin"));
        bankService.create(bank);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("redirect:/bank/list");
        return modelAndView;
    }

    @RequestMapping(value = "/bank/list", method = RequestMethod.GET)
    public ModelAndView bankList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Bank> bankList = bankService.showAll();
        modelAndView.addObject("bankList", bankList);

        modelAndView.setViewName("bank/list-bank");
        return modelAndView;
    }

    @RequestMapping(value = "/bank/edit/{bankCode}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("bankCode") String bankCode){
        ModelAndView modelAndView = new ModelAndView();
        Bank bank = bankService.findByBankCode(bankCode);
        modelAndView.addObject("bank", bank);
        modelAndView.setViewName("bank/edit-bank");
        return modelAndView;
    }

    @RequestMapping(value = "/bank/edit/{bankCode}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("bankCode") String bankCode, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        Bank bank = new Bank();
        bank.setBankCode(bankCode);
        bank.setBankName(data.get("bankName"));
        bank.setBin(data.get("bin"));
        bankService.update(bankCode,bank);
        modelAndView.setViewName("redirect:/bank/list");
        return modelAndView;
    }

    @RequestMapping(value = "/bank/delete/{bankCode}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("bankCode") String bankCode){
        ModelAndView modelAndView = new ModelAndView();
        bankService.delete(bankCode);
        modelAndView.setViewName("redirect:/bank/list");
        return modelAndView;
    }
}
