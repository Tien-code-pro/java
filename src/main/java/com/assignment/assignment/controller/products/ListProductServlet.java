package com.assignment.assignment.controller.products;

import com.assignment.assignment.entity.Account;
import com.assignment.assignment.entity.Products;
import com.assignment.assignment.model.MySqlProductModel;
import com.assignment.assignment.model.MySqlVegetablesModel;
import com.assignment.assignment.model.ProductsModel;
import com.assignment.assignment.model.VegetablesModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {
    private ProductsModel productsModel;
    public ListProductServlet() {
        this.productsModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Products> list = productsModel.findAll();
        req.setAttribute("ListAccount",list);
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req,resp);
    }
}
