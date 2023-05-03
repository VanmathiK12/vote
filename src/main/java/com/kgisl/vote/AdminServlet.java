package com.kgisl.vote;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("admin_email");
        String password = req.getParameter("admin_password");
        System.out.println(email + "" + password);
        RequestDispatcher rd = req.getRequestDispatcher("Result.html");
        rd.forward(req, resp);
    }
}
