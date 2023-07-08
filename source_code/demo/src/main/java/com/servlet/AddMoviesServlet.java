package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import com.dao.MovieDAOImpl;
import com.db.DBConnect;
import com.entity.MoviesDetails;

@WebServlet(name = "AddMoviesServlet", value = "/AddMoviesServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 50,
        maxRequestSize = 1024 * 1024 * 100)
public class AddMoviesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public AddMoviesServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String movieTitle = request.getParameter("movieTitle");
            String movieGenre = request.getParameter("movieGenre");
            String movieYear = request.getParameter("movieYear");
            String urlYoutube = request.getParameter("urlYoutube");

            Part part = request.getPart("photo");
            String fileName = part.getSubmittedFileName();

            MoviesDetails b = new MoviesDetails(movieTitle, movieGenre, movieYear, fileName, "admin", urlYoutube);

            MovieDAOImpl dao = new MovieDAOImpl(DBConnect.getConn());

            boolean f = dao.addMovies(b);

            HttpSession session = request.getSession();

            if (f) {
                // Menyimpan file sementara di direktori temp
                String tempDirectory = getServletContext().getRealPath("") + File.separator + "temp";
                File tempFile = new File(tempDirectory, fileName);
                part.write(tempFile.getAbsolutePath());

                // Memindahkan file dari temp directory ke destination directory
                String destinationDirectory = "C:\\Users\\mraur\\intellij_project\\demo\\src\\main\\webapp\\assets\\images";
                File destinationFile = new File(destinationDirectory, fileName);
                Files.move(tempFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                response.sendRedirect("admin.jsp");
            } else {
                session.setAttribute("failedMsg", "Something went wrong on the server");
                response.sendRedirect("admin.jsp");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
