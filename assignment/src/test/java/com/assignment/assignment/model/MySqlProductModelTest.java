package com.assignment.assignment.model;

import com.assignment.assignment.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MySqlProductModelTest {

    ProductModel product;
    @BeforeEach
    void setUp() {
        product = new MySqlProductModel();
    }

    @Test
    void findById() {
        System.out.println(product.findById("A123"));
    }

    @Test
    void findBycategoryId() {
        List<Product> list = product.findBycategoryId("2");
        System.out.println(list.toString());
    }
}