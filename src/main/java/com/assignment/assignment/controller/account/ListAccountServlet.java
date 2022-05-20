package com.assignment.assignment.controller.account;

import com.assignment.assignment.entity.Account;
import com.assignment.assignment.model.MySqlVegetablesModel;
import com.assignment.assignment.model.VegetablesModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAccountServlet extends HttpServlet {
    private VegetablesModel vegetablesModel;
    public ListAccountServlet() {
        this.vegetablesModel = new MySqlVegetablesModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Account> list = vegetablesModel.findAll();
        req.setAttribute("ListAccount",list);
        req.getRequestDispatcher("/admin/account/list.jsp").forward(req,resp);
    }
}
