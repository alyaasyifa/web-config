package com.mib.webconfig.controller;

import com.mib.webconfig.entity.Product;
import com.mib.webconfig.service.ProductService;
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
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/create", method = RequestMethod.GET)
    public String showCreateForm() { return "product/add-product"; }

    @RequestMapping(value = "/product/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam Map<String, String> data) throws URISyntaxException {
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product();
        product.setProductCode(data.get("productCode"));
        product.setProductName(data.get("productName"));
        product.setAgregatorName(data.get("agregatorName"));
        product.setFee(data.get("fee"));
        productService.create(product);
        String sccMsg ="Data saved successfully";
        modelAndView.addObject("sccMsg", sccMsg);
        modelAndView.setViewName("product/add-product");
        return modelAndView;
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public  ModelAndView productList(){
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.showAll();
        modelAndView.addObject("productList", productList);

        modelAndView.setViewName("product/list-product");
        return modelAndView;
    }

    @RequestMapping(value = "/product/edit/{productCode}", method = RequestMethod.GET)
    public ModelAndView showEditForm(@PathVariable("productCode") String productCode){
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.findByProductCode(productCode);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("product/edit-product");
        return modelAndView;
    }

    @RequestMapping(value = "/product/edit/{productCode}", method = RequestMethod.POST)
    public ModelAndView update(@PathVariable("productCode") String productCode, @RequestParam Map<String,String> data){
        ModelAndView modelAndView = new ModelAndView();
        Product product = new Product();
        product.setProductCode(productCode);
        product.setProductName(data.get("productName"));
        product.setAgregatorName(data.get("agregatorName"));
        product.setFee(data.get("fee"));
        productService.update(productCode,product);
        modelAndView.setViewName("redirect:/product/list");
        return modelAndView;
    }

    @RequestMapping(value = "/product/delete/{productCode}", method = {RequestMethod.POST, RequestMethod.GET})
    public  ModelAndView delete(@PathVariable("productCode")String productCode){
        ModelAndView modelAndView = new ModelAndView();
        productService.delete(productCode);
        modelAndView.setViewName("redirect:/product/list");
        return modelAndView;
    }
}
