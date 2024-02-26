package com.mib.webconfig.controller;

import com.mib.webconfig.entity.MasterProductCodeEnitity;
import com.mib.webconfig.service.MasterProductCodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/productCode")

public class MasterProductCodeController{
    private  final MasterProductCodeService service;


    public MasterProductCodeController(MasterProductCodeService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createDataNewElement(@RequestBody MasterProductCodeEnitity data) throws URISyntaxException {
        service.create(data);
        return ResponseEntity.created(new URI("/create")).build();
    }

    @GetMapping("/show")
    public ResponseEntity<List<MasterProductCodeEnitity>> showAllProductEntity(){
        List<MasterProductCodeEnitity> dataElement =service.showAll();
        return ResponseEntity.ok().body(dataElement);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Void> updateDataElement(@PathVariable("id") Long productId, @RequestBody MasterProductCodeEnitity data){
        service.update(productId, data);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteDataElement(@PathVariable("id") Long dataId){
        service.delete(dataId);
        return ResponseEntity.ok().build();
    }

}
