package com.mib.webconfig.controller;

import com.mib.webconfig.service.ReportService;
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
public class ReportController {

    private static final Logger log = LoggerFactory.getLogger(ReportController.class);
    @Autowired
    private ReportService reportService;

    @RequestMapping(value = "/reporting/product-code", method = RequestMethod.GET)
    public ModelAndView showProductReportForm(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("reporting/product-code");
        return modelAndView;
    }

    @RequestMapping(value = "/reporting/public-key", method = RequestMethod.GET)
    public ModelAndView showProductReportFormKey(){
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("reporting/public-key");
        return modelAndView;
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
    public ResponseEntity<Object> createProductReport(@RequestParam(value = "exportType",required = false) String exportType,
                                                      HttpServletResponse response) {
        try {
            reportService.createGuruReport(exportType,response);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
