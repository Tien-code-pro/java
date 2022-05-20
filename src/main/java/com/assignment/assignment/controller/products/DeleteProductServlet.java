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

public class DeleteProductServlet extends HttpServlet {

    private ProductsModel productsModel;
    public DeleteProductServlet() {
        this.productsModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Products products = productsModel.findById(id);

        if (products == null) {
            req.setAttribute("message", "Data not found!");
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req, resp);
        } else {
            boolean result = productsModel.delete(id); // xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/products/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
            }
        }
    }
}
