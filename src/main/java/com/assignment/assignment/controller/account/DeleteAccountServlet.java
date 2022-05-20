package com.assignment.assignment.controller.account;

import com.assignment.assignment.entity.Account;
import com.assignment.assignment.model.MySqlVegetablesModel;
import com.assignment.assignment.model.VegetablesModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteAccountServlet extends HttpServlet {

    private VegetablesModel vegetablesModel;
    public DeleteAccountServlet() {
        this.vegetablesModel = new MySqlVegetablesModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        Account account = vegetablesModel.findById(id);

        if (account == null) {
            req.setAttribute("message", "Data not found!");
            req.getRequestDispatcher("/admin/error/404.jsp").forward(req, resp);
        } else {
            boolean result = vegetablesModel.delete(id); // xoá mềm.
            if (result) {
                resp.sendRedirect("/admin/account/list");
            } else {
                req.setAttribute("message", "Action fails!");
                req.getRequestDispatcher("/admin/error/500.jsp").forward(req, resp);
            }
        }
    }
}
