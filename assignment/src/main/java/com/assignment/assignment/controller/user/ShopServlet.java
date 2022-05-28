package com.assignment.assignment.controller.user;

import com.assignment.assignment.entity.Category;
import com.assignment.assignment.entity.Product;
import com.assignment.assignment.model.CategoryModel;
import com.assignment.assignment.model.MySqlCategoryModel;
import com.assignment.assignment.model.MySqlProductModel;
import com.assignment.assignment.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShopServlet extends HttpServlet {

    private ProductModel productModel;
    private CategoryModel categoryModel;
    public ShopServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        List<Category> category = categoryModel.findAll();
        req.setAttribute("title","Shop");
        req.setAttribute("listProduct",products);
        req.setAttribute("category", category);
        req.getRequestDispatcher("/user/shop/shop.jsp").forward(req,resp);
    }
}
