package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Jurusan;
import com.mib.webconfig.entity.Siswa;
import com.mib.webconfig.service.JurusanService;
import com.mib.webconfig.service.SiswaService;
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
public class SiswaController {

    @Autowired
    private SiswaService siswaService;

    @RequestMapping(value = "/siswa/create", method = RequestMethod.GET)
    public String showCreateForm(){
        return "siswa/add-siswa";
    }

    @RequestMapping(value = "/siswa/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String,String> data) {
        ModelAndView modelAndView = new ModelAndView();
        Siswa siswa = new Siswa();
        siswa.setNis(data.get("nis"));
        siswa.setNamaSiswa(data.get("namaSiswa"));
        siswaService.create(siswa);
        String sccMsg = "Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("siswa/add-siswa");
        return modelAndView;
    }

    @RequestMapping(value = "/siswa/list", method = RequestMethod.GET)
    public ModelAndView siswaList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Siswa> siswaList = siswaService.showAll();
        modelAndView.addObject("siswaList", siswaList);

        modelAndView.setViewName("siswa/list-siswa");
        return modelAndView;
    }

    @RequestMapping(value="/siswa/edit/{nis}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("nis") String nis){
        ModelAndView modelAndView = new ModelAndView();
        Siswa siswa = siswaService.findByNis(nis);
        modelAndView.addObject("siswa", siswa);
        modelAndView.setViewName("siswa/edit-siswa");
        return modelAndView;
    }

    @RequestMapping(value = "/siswa/edit/{nis}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("nis") String nis, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        Siswa siswa = new Siswa();
        siswa.setNis(nis);
        siswa.setNamaSiswa(data.get("namaSiswa"));
        siswaService.update(nis,siswa);
        modelAndView.setViewName("redirect:/siswa/list");
        return modelAndView;
    }

    @RequestMapping(value = "/siswa/delete/{nis}", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView delete(@PathVariable("nis") String nis){
        ModelAndView modelAndView = new ModelAndView();
        siswaService.delete(nis);
        modelAndView.setViewName("redirect:/siswa/list");
        return modelAndView;
    }

}
