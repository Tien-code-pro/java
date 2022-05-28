package com.assignment.assignment.controller.user;

import com.assignment.assignment.entity.Product;
import com.assignment.assignment.model.MySqlProductModel;
import com.assignment.assignment.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {

    private ProductModel productModel;

    public HomeServlet() {
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        req.setAttribute("title","Home");
        req.setAttribute("listProduct",products);
        req.getRequestDispatcher("/user/home/index.jsp").forward(req,resp);
    }
}
