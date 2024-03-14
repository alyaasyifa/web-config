package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Guru;
import com.mib.webconfig.entity.Jurusan;
import com.mib.webconfig.service.GuruService;
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
public class GuruController {
    @Autowired
    private GuruService guruService;

    @RequestMapping(value = "/guru/create", method = RequestMethod.GET)
    public String showCreateForm() { return "guru/add-guru"; }

    @RequestMapping(value = "/guru/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String, String> data) throws URISyntaxException {
        ModelAndView modelAndView = new ModelAndView();
        Guru guru = new Guru();
        guru.setKodeGuru(data.get("kodeGuru"));
        guru.setNamaGuru(data.get("namaGuru"));
        guruService.create(guru);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("guru/add-guru");
        return modelAndView;
    }

    @RequestMapping(value = "/guru/list", method = RequestMethod.GET)
    public ModelAndView guruList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Guru> guruList = guruService.showAll();
        modelAndView.addObject("guruList", guruList);

        modelAndView.setViewName("guru/list-guru");
        return modelAndView;
    }

    @RequestMapping(value="/guru/edit/{kodeGuru}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("kodeGuru") String kodeGuru){
        ModelAndView modelAndView = new ModelAndView();
        Guru guru = guruService.findByKodeGuru(kodeGuru);
        modelAndView.addObject("guru", guru);
        modelAndView.setViewName("guru/edit-guru");
        return modelAndView;
    }

    @RequestMapping(value = "/guru/edit/{kodeGuru}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("kodeGuru") String kodeGuru, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        Guru guru = new Guru();
        guru.setKodeGuru(kodeGuru);
        guru.setNamaGuru(data.get("namaGuru"));
        guruService.update(kodeGuru,guru);
        modelAndView.setViewName("redirect:/guru/list");
        return modelAndView;
    }

    @RequestMapping(value = "/guru/delete/{kodeGuru}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("kodeGuru") String kodeGuru){
        ModelAndView modelAndView = new ModelAndView();
        guruService.delete(kodeGuru);
        modelAndView.setViewName("redirect:/guru/list");
        return modelAndView;
    }
}
