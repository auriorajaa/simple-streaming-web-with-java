package com.servlet;

import com.dao.MovieDAOImpl;
import com.db.DBConnect;
import com.entity.MoviesDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Register
 */
@WebServlet(name = "EditMoviesServlet", value = "/EditMoviesServlet")

public class EditMoviesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String movieTitle = request.getParameter("movieTitle");
            String movieGenre = request.getParameter("movieGenre");
            String movieYear = request.getParameter("movieYear");
            String urlYoutube = request.getParameter("urlYoutube");

            MoviesDetails b = new MoviesDetails();
            b.setMovieId(id);
            b.setMovieTitle(movieTitle);
            b.setMovieGenre(movieGenre);
            b.setMovieYear(movieYear);
            b.setUrlYoutube(urlYoutube);

            MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());
            boolean f = dao.updateEditMovies(b);

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
