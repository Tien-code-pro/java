package com.assignment.assignment.controller.user;

import com.assignment.assignment.entity.Category;
import com.assignment.assignment.entity.Color;
import com.assignment.assignment.entity.Product;
import com.assignment.assignment.entity.Size;
import com.assignment.assignment.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class CartDetailServlet extends HttpServlet {


    private ProductModel productModel;
    private ColorModel colorModel;
    private CategoryModel categoryModel;
    private SizeModel sizeModel;


    public CartDetailServlet() {
        this.productModel = new MySqlProductModel();
        this.colorModel = new MySqlColorModel();
        this.categoryModel = new MySqlCategoryModel();
        this.sizeModel = new MySqlSizeModel();
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("title", "Shop Detail");
        Product product = productModel.findById(id);
        List<Color> color = colorModel.findAll();
        List<Category> category = categoryModel.findAll();
        List<Size> sizes = sizeModel.findAll();

        List<Product> products = productModel.findAll();
//        req.setAttribute("title","List Product");
        req.setAttribute("listProduct",products);

        if (product == null) {
            req.setAttribute("message", "Data not found!");
            req.getRequestDispatcher("/user/errors/404.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            req.setAttribute("product", product);
            req.setAttribute("color", color);
            req.setAttribute("category", category);
            req.setAttribute("size",sizes);
            req.getRequestDispatcher("/user/shop/detail.jsp").forward(req, resp);
        }
    }
}
