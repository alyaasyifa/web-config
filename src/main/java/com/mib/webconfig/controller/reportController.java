package com.mib.webconfig.controller;


import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class reportController {

    private static final Logger log = LoggerFactory.getLogger(reportController.class);
    @Autowired
    private com.mib.webconfig.service.reportService reportService;

    @RequestMapping(value = "/reporting/product-code", method = RequestMethod.GET)
    public ModelAndView showProductReportForm(){
        ModelAndView modelAndView = new ModelAndView();

        List<String> exportType = new ArrayList<>();
        exportType.add("CSV");
        exportType.add("DOCX");
        exportType.add("EXCEL");
        exportType.add("PDF");
        modelAndView.addObject("exportType", exportType);
        modelAndView.setViewName("reporting/product-code");
        return modelAndView;
    }

    @RequestMapping(value = "/reporting/product/download", method = { RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<Object> createProductReport(@RequestParam(value = "exportType", required = false) String exporType,
                                                      HttpServletResponse response){
        try {
            reportService.createProductReport(exporType,response);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(value = "/reporting/guru", method = RequestMethod.GET)
    public ModelAndView showGuruReportForm(){
        ModelAndView modelAndView = new ModelAndView();

        List<String> exportType = new ArrayList<>();
        exportType.add("CSV");
        exportType.add("DOCX");
        exportType.add("EXCEL");
        exportType.add("PDF");
        modelAndView.addObject("exportType", exportType);
        modelAndView.setViewName("reporting/guru");
        return modelAndView;
    }

    @RequestMapping(value="/reporting/guru/download", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<Object> createGuruReport(@RequestParam(value = "exportType",required = false) String exportType,
                                                      HttpServletResponse response) {
        try {
            reportService.createGuruReport(exportType, response);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @RequestMapping(value = "/reporting/movie", method = RequestMethod.GET)
    public ModelAndView showMovieReportForm(){
        ModelAndView modelAndView = new ModelAndView();

        List<String> exportType = new ArrayList<>();
        exportType.add("CSV");
        exportType.add("DOCX");
        exportType.add("EXCEL");
        exportType.add("PDF");
        modelAndView.addObject("exportType", exportType);
        modelAndView.setViewName("reporting/movie");
        return modelAndView;
    }

    @RequestMapping(value="/reporting/movie/download", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<Object> createMovieReport(@RequestParam(value = "exportType",required = false) String exportType,
                                                    HttpServletResponse response) {
        try {
            reportService.createMovieReport(exportType, response);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @RequestMapping(value = "/reporting/publicKey", method = RequestMethod.GET)
    public ModelAndView showPublicKeyReportForm(){
        ModelAndView modelAndView = new ModelAndView();

        List<String> exportType = new ArrayList<>();
        exportType.add("CSV");
        exportType.add("DOCX");
        exportType.add("EXCEL");
        exportType.add("PDF");
        modelAndView.addObject("exportType", exportType);
        modelAndView.setViewName("reporting/publicKey");
        return modelAndView;
    }

    @RequestMapping(value="/reporting/publicKey/download", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<Object> createPublicKeyReport(@RequestParam(value = "exportType",required = false) String exportType,
                                                    HttpServletResponse response) {
        try {
            reportService.createPublicKeyReport(exportType, response);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @RequestMapping(value = "/reporting/siswa", method = RequestMethod.GET)
    public ModelAndView showSiswaReportForm(){
        ModelAndView modelAndView = new ModelAndView();

        List<String> exportType = new ArrayList<>();
        exportType.add("CSV");
        exportType.add("DOCX");
        exportType.add("EXCEL");
        exportType.add("PDF");
        modelAndView.addObject("exportType", exportType);
        modelAndView.setViewName("Siswa");
        return modelAndView;
    }

    @RequestMapping(value="/reporting/siswa/download", method = { RequestMethod.GET, RequestMethod.POST })
    public ResponseEntity<Object> createSiswaReport(@RequestParam(value = "exportType",required = false) String exportType,
                                                        HttpServletResponse response) {
        try {
            reportService.createSiswaReport(exportType, response);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
}