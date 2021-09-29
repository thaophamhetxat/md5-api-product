package com.md5apiproduct.services;

import com.md5apiproduct.models.Product;
import com.md5apiproduct.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepo iProductRepo;

    @Override
    public Product save(Product product) {
        return iProductRepo.save(product);
    }

    @Override
    public Product findById(long id) {
        return iProductRepo.findById(id).get();
    }

    @Override
    public ArrayList<Product> findAll() {
        return (ArrayList<Product>) iProductRepo.findAll();
    }

    @Override
    public ArrayList<Product> findAllByName(String name) {
        return iProductRepo.findAllByName(name);
    }

    @Override
    public void delete(Product product) {
        iProductRepo.delete(product);
    }

    @Override
    public void edit(Product product) {
        iProductRepo.delete(product);
    }
}
