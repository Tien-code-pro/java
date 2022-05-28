package com.assignment.assignment.controller.user;

import com.assignment.assignment.entity.Product;
import com.assignment.assignment.entity.shoppingcart.ShoppingCart;
import com.assignment.assignment.model.MySqlProductModel;
import com.assignment.assignment.model.ProductModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteCartServlet extends HttpServlet {
    private ProductModel productModel;
    public DeleteCartServlet(){
        this.productModel = new MySqlProductModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
        String productId = String.valueOf( req.getParameter("id"));
        Product product = productModel.findById(String.valueOf(productId));
        if (product == null){
            req.setAttribute("message", "Product not found!");
            req.getRequestDispatcher("/user/error/404.jsp").forward(req,resp);
            return;
        }
        shoppingCart.remove(product);
        session.setAttribute("shoppingCart",shoppingCart);
        resp.sendRedirect("/cart/show");
    }
}
