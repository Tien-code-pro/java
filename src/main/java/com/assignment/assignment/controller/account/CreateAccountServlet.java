package com.assignment.assignment.controller.account;

import com.assignment.assignment.entity.Account;
import com.assignment.assignment.model.MySqlVegetablesModel;
import com.assignment.assignment.model.VegetablesModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateAccountServlet extends HttpServlet {

    private VegetablesModel vegetablesModel;
    public CreateAccountServlet() {
        this.vegetablesModel = new MySqlVegetablesModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("account", new Account());
        req.setAttribute("action", 1);
        req.getRequestDispatcher("/admin/account/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("userName");
            String password = req.getParameter("Password");
            String firstName = req.getParameter("FirstName");
            String lastName = req.getParameter("LastName");
            String email = req.getParameter("Email");
            String phone = req.getParameter("Phone");
            String address = req.getParameter("Address");
            String country = req.getParameter("Country");
//            String stringDob = req.getParameter("dob");
//            LocalDateTime dob = DateTimeHelper.convertStringToLocalDateTime(stringDob);
            Account account = new Account(id,name,password,firstName,lastName,email, phone, address, country);

            if (vegetablesModel.update(id, account) != null) {
                resp.sendRedirect("/admin/account/list");
            } else {
                req.getRequestDispatcher("/admin/account/form.jsp").forward(req, resp);
        }
    }
}
