package com.kgisl.vote;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = { "/login"})
public class VoterLoginFilter implements Filter {
    public VoterDAO voterDAO;
    public AdminDAO adminDAO;

    @Override
    public void destroy() {

        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain
    chain)
    throws IOException, ServletException {
    System.out.println("dofilter()called");
    String userMail = req.getParameter("email");
    String userPass = req.getParameter("password");
    voterDAO = VoterDAO.getInstance("jdbc:mysql://localhost:3306/votingsystem",
    "root", "");
    List<Voter> emailList;
    try {
    emailList = voterDAO.getEmailPass();
    Iterator<Voter> itr = emailList.iterator();
    boolean flag = false;
    while (itr.hasNext()) {
    Voter voter = itr.next();
    String email = voter.getEmail();
    String pass = voter.getPassword();
    if (userMail.equals(email) && userPass.equals(pass)) {
    flag = true;
    chain.doFilter(req, resp);
    }
    }
    if (!flag) {
    PrintWriter out = resp.getWriter();
    resp.setContentType("text/html");
    out.print("UserEmail or Password Invalid");
    RequestDispatcher rd = req.getRequestDispatcher("userLogin.html");
    rd.include(req, resp);
    }
    } catch (SQLException e) {

    e.printStackTrace();
    }

}

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}