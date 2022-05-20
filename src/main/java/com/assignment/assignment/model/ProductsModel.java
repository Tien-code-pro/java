package com.assignment.assignment.model;


import com.assignment.assignment.entity.Products;

import java.util.List;

public interface ProductsModel {

    Products save(Products products);

    List<Products> findAll();

    Products findById(int id);

    Products update(int id, Products updateProducts);

    boolean delete(int id);
}
