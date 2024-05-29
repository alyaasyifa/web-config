package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Jurusan;
import com.mib.webconfig.service.JurusanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@Controller
public class JurusanController {

    @Autowired
    private JurusanService jurusanService;

    @RequestMapping(value = "/jurusan/create", method = RequestMethod.GET)
    public String showCreateForm(){
        return "jurusan/add-jurusan";
    }

    @RequestMapping(value = "/jurusan/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String,String> data) throws URISyntaxException {
        ModelAndView modelAndView = new ModelAndView();
        Jurusan jurusan = new Jurusan();
        jurusan.setKodeJurusan(data.get("kodeJurusan"));
        jurusan.setNamaJurusan(data.get("namaJurusan"));
        jurusanService.create(jurusan);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("redirect:/jurusan/list");
        return modelAndView;
    }

    @RequestMapping(value = "/jurusan/list", method = RequestMethod.GET)
    public ModelAndView jurusanList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Jurusan> jurusanList = jurusanService.showAll();
        modelAndView.addObject("jurusanList", jurusanList);

        modelAndView.setViewName("jurusan/list-jurusan");
        return modelAndView;
    }

    @RequestMapping(value="/jurusan/edit/{kodeJurusan}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("kodeJurusan") String kodeJurusan){
        ModelAndView modelAndView = new ModelAndView();
        Jurusan jurusan = jurusanService.findByKodeJurusan(kodeJurusan);
        modelAndView.addObject("jurusan", jurusan);
        modelAndView.setViewName("jurusan/edit-jurusan");
        return modelAndView;
    }

    @RequestMapping(value = "/jurusan/edit/{kodeJurusan}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("kodeJurusan") String kodeJurusan, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        Jurusan jurusan = new Jurusan();
        jurusan.setKodeJurusan(kodeJurusan);
        jurusan.setNamaJurusan(data.get("namaJurusan"));
        jurusanService.update(kodeJurusan,jurusan);
        modelAndView.setViewName("redirect:/jurusan/list");
        return modelAndView;
    }

    @RequestMapping(value = "/jurusan/delete/{kodeJurusan}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("kodeJurusan") String kodeJurusan){
        ModelAndView modelAndView = new ModelAndView();
        jurusanService.delete(kodeJurusan);
        modelAndView.setViewName("redirect:/jurusan/list");
        return modelAndView;
    }

}
