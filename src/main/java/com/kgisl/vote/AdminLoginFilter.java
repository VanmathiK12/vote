package com.kgisl.vote;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = {"/admin"})
public class AdminLoginFilter implements Filter {
    public AdminDAO adminDAO;

    @Override
    public void destroy() {

        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain
    chain)
    throws IOException, ServletException {
    System.out.println("Admin dofilter()called");
    String adminMail = req.getParameter("admin_email");
    String adminPass = req.getParameter("admin_password");
    adminDAO = AdminDAO.getInstance("jdbc:mysql://localhost:3306/votingsystem",
    "root", "");
    // String adminEmail = admin.getAdmin_email();
    // String admin_pass = admin.getAdmin_password();
    if (adminMail.equals("admin@gmail.com") && adminPass.equals("admin")) {
        System.out.println("admin email,pass");
    //flag = true;
    chain.doFilter(req, resp);
    }

   else {
    PrintWriter out = resp.getWriter();
    resp.setContentType("text/html");
    out.print("UserEmail or Password Invalid");
    RequestDispatcher rd = req.getRequestDispatcher("adminLogin.html");
    rd.include(req, resp);
    }
    } //catch (SQLException e) {

    //e.printStackTrace();
    //}

    

    @Override
public void init(FilterConfig filterConfig) throws ServletException {
    adminDAO = AdminDAO.getInstance("jdbc:mysql://localhost:3306/votingsystem", "root", "");
}
}