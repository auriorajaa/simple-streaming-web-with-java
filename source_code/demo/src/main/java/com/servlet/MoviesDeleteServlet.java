package com.servlet;

import com.dao.MovieDAOImpl;
import com.db.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.dao.Member;
import com.dao.RegisterDao;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "MoviesDeleteServlet", value = "/MoviesDeleteServlet")

public class MoviesDeleteServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        try {

            int id = Integer.parseInt(request.getParameter("id"));

            MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
            boolean f = dao.deleteMovies(id);

            HttpSession session = request.getSession();

            if (f) {
                response.sendRedirect("admin.jsp");
            } else {
                session.setAttribute("failedMsg", "Something wrong on server..");
                response.sendRedirect("admin.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
