package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.dao.Member;
import com.dao.RegisterDao;

@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public Register() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String uname = request.getParameter("username");
        String password = request.getParameter("password");
        String subscription = request.getParameter("subscription"); // Get subscription value

        Member member = new Member(email, uname, password);
        member.setSubscription(subscription); // Set the subscription value

        RegisterDao rDao = new RegisterDao();
        String result = rDao.insert(member);

        // Set the result message as a request attribute
        request.setAttribute("result", result);

        // Forward the request to registration.jsp
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}
