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
import java.util.ArrayList;
import java.util.List;

public class categoryServlet extends HttpServlet {
    private ProductModel productModel;
    private CategoryModel categoryModel;

    public categoryServlet() {
        this.productModel = new MySqlProductModel();
        this.categoryModel = new MySqlCategoryModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("title","Shop");
        String cateID = req.getParameter("cid");
        List<Product> products = productModel.findBycategoryId(cateID);
        if(products == null){
            products = new ArrayList<>();
        }
        req.setAttribute("category", categoryModel.findAll());
        req.setAttribute("listProduct", products);
        req.getRequestDispatcher("/user/shop/shopCategory.jsp").forward(req,resp);

    }
}
