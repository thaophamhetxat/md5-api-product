package com.md5apiproduct.controllers;

import com.md5apiproduct.models.Product;
import com.md5apiproduct.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products/")
public class ApiControllers {
    @Autowired
    IProductService iProductService;


    @GetMapping("")
    public ResponseEntity<Product> findAllProduct() {
        List<Product> products = iProductService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(products, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<>(iProductService.save(product), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> showEdit(@PathVariable long id) {
        return new ResponseEntity<>(iProductService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> edit(@RequestBody Product product) {
        return new ResponseEntity<>(iProductService.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable long id) {
        iProductService.delete(iProductService.findById(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
