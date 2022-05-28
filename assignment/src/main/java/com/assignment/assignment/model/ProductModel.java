package com.assignment.assignment.model;

import com.assignment.assignment.entity.Category;
import com.assignment.assignment.entity.Product;

import java.util.List;

public interface ProductModel {

    Product save(Product product);

    List<Product> findAll();

    Product findById(String id);

    Product update(String id,Product product);

    boolean delete(String id);

//    Product findById(String id, Category category);



    List<Product> findBycategoryId(String cid);
}
