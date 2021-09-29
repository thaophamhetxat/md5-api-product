package com.md5apiproduct.controllers;

import com.md5apiproduct.models.Product;
import com.md5apiproduct.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ApiControllers {
    @Autowired
    IProductService iProductService;


    @GetMapping("")
    public ResponseEntity<Product> findAllHocVien() {
        List<Product> hocViens = iProductService.findAll();
        if (hocViens.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(hocViens, HttpStatus.OK);
    }

}
