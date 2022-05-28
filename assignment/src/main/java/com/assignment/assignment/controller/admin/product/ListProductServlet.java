package com.assignment.assignment.controller.admin.product;

import com.assignment.assignment.entity.Product;
import com.assignment.assignment.entity.Size;
import com.assignment.assignment.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListProductServlet extends HttpServlet {

    private ProductModel productModel;
    private SizeModel sizeModel;

    public ListProductServlet() {
        this.productModel = new MySqlProductModel();
        this.sizeModel = new MySqlSizeModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productModel.findAll();
        List<Size> sizes = sizeModel.findAll();
        req.setAttribute("title","List Product");
        req.setAttribute("listProduct",products);
        req.setAttribute("size",sizes);
        req.getRequestDispatcher("/admin/products/list.jsp").forward(req,resp);
    }
}
