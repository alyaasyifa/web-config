package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Rekening;
import com.mib.webconfig.service.RekeningService;
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
public class RekeningController {

    @Autowired
    private RekeningService rekeningService;

    @RequestMapping(value = "/rekening/create", method = RequestMethod.GET)
    public String showCreateForm() { return "rekening/add-rekening"; }

    @RequestMapping(value = "/rekening/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String, String> data) throws URISyntaxException {
        ModelAndView modelAndView = new ModelAndView();
        Rekening rekening = new Rekening();
        rekening.setClientId(data.get("clientId"));
        rekening.setNoRekening(data.get("noRekening"));
        rekeningService.create(rekening);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("redirect:/rekening/list");
        return modelAndView;
    }

    @RequestMapping(value = "/rekening/list", method = RequestMethod.GET)
    public ModelAndView rekeningList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Rekening> rekeningList = rekeningService.showAll();
        modelAndView.addObject("rekeningList", rekeningList);

        modelAndView.setViewName("rekening/list-rekening");
        return modelAndView;
    }

    @RequestMapping(value = "/rekening/edit/{clientId}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("clientId") String clientId){
        ModelAndView modelAndView = new ModelAndView();
        Rekening rekening = rekeningService.findByClientId(clientId);
        modelAndView.addObject("rekening", rekening);
        modelAndView.setViewName("rekening/edit-rekening");
        return modelAndView;
    }

    @RequestMapping(value = "/rekening/edit/{clientId}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("clientId") String clientId, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        Rekening rekening = new Rekening();
        rekening.setClientId(clientId);
        rekening.setNoRekening(data.get("noRekening"));
        rekeningService.update(clientId,rekening);
        modelAndView.setViewName("redirect:/rekening/list");
        return modelAndView;
    }

    @RequestMapping(value = "rekening/delete/{clientId}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("clientId") String clientId){
        ModelAndView modelAndView = new ModelAndView();
        rekeningService.delete(clientId);
        modelAndView.setViewName("redirect:/rekening/list");
        return modelAndView;
    }
}
