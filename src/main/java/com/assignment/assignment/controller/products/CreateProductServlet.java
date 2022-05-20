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

public class CreateProductServlet extends HttpServlet {

    private ProductsModel productsModel;
    public CreateProductServlet() {
        this.productsModel = new MySqlProductModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", new Products());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/products/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String image = req.getParameter("image");
            String title = req.getParameter("title");
            String size = req.getParameter("size");
            int qty = Integer.parseInt(req.getParameter("qty"));
            int rate = Integer.parseInt(req.getParameter("rate"));
            String mass = req.getParameter("mass");
//            String stringDob = req.getParameter("dob");
//            LocalDateTime dob = DateTimeHelper.convertStringToLocalDateTime(stringDob);
        Products products = new Products(id,name,price,image,title,size, qty, rate, mass);

            if (productsModel.update(id, products) != null) {
                resp.sendRedirect("/admin/products/list");
            } else {
                req.getRequestDispatcher("/admin/products/form.jsp").forward(req, resp);
        }
    }
}
