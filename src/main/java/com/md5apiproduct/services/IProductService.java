package com.md5apiproduct.services;

import com.md5apiproduct.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface IProductService {
    Product save(Product product);
    Product findById(long id);

    ArrayList<Product> findAll();

    ArrayList<Product> findAllByName(String name);

    void delete(Product product);

    void edit(Product product);
}
