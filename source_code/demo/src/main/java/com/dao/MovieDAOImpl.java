package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.MoviesDetails;

public class MovieDAOImpl implements MovieDAO {

    private Connection conn;

    public MovieDAOImpl(Connection conn) {
        super();
        this.conn = conn;
    }

    @Override
    public boolean addMovies(MoviesDetails b) {
        // TODO Auto-generated method stub

        boolean f = false;

        try {

            String sql = "INSERT INTO tbl_movies (movie_title, movie_genre, movie_year, image, url_youtube) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.getMovieTitle());
            ps.setString(2, b.getMovieGenre());
            ps.setString(3, b.getMovieYear());
            ps.setString(4, b.getImageName());
            ps.setString(5, b.getUrlYoutube());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    @Override
    public List<MoviesDetails> getAllMovies() {
        List<MoviesDetails> list = new ArrayList<MoviesDetails>();
        MoviesDetails b = null;

        try {
            String sql = "SELECT * FROM tbl_movies order by id desc";
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b = new MoviesDetails();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));

                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public MoviesDetails getMovieById(int id) {
        MoviesDetails b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b = new MoviesDetails();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return b;
    }

    @Override
    public boolean updateEditMovies(MoviesDetails b) {
        boolean f = false;

        try {
            String sql = "UPDATE tbl_movies set movie_title=?, movie_genre=?, movie_year=?, url_youtube=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, b.getMovieTitle());
            ps.setString(2, b.getMovieGenre());
            ps.setString(3, b.getMovieYear());
            ps.setString(4, b.getUrlYoutube());
            ps.setInt(5, b.getMovieId());

            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    @Override
    public boolean deleteMovies(int id) {
        boolean f = false;

        try {
            String sql = "DELETE FROM tbl_movies WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            int i = ps.executeUpdate();

            if (i == 1) {
                f = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return f;
    }

    @Override
    public List<MoviesDetails> getActionMovie() {

        List<MoviesDetails> list = new ArrayList<MoviesDetails>();
        MoviesDetails b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Action");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new MoviesDetails();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<MoviesDetails> getAdventureMovie() {

        List<MoviesDetails> list = new ArrayList<MoviesDetails>();
        MoviesDetails b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Adventure");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new MoviesDetails();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<MoviesDetails> getMovieBySearch(String ch) {
        List<MoviesDetails> list = new ArrayList<MoviesDetails>();
        MoviesDetails b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_title LIKE ? OR movie_genre LIKE ? or movie_year LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + ch + "%");
            ps.setString(2, "%" + ch + "%");
            ps.setString(3, "%" + ch + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b = new MoviesDetails();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<MoviesDetails> getFamilyMovie() {
        List<MoviesDetails> list = new ArrayList<MoviesDetails>();
        MoviesDetails b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Family");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new MoviesDetails();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<MoviesDetails> getHorrorMovie() {
        List<MoviesDetails> list = new ArrayList<MoviesDetails>();
        MoviesDetails b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Horror");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new MoviesDetails();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<MoviesDetails> getThrillerMovie() {
        List<MoviesDetails> list = new ArrayList<MoviesDetails>();
        MoviesDetails b = null;

        try {
            String sql = "SELECT * FROM tbl_movies WHERE movie_genre=? ORDER BY id DESC";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "Thriller");
            ResultSet rs = ps.executeQuery();

            int i = 0;
            while (rs.next() && i <= 18) {
                b = new MoviesDetails();
                b.setMovieId(rs.getInt(1));
                b.setMovieTitle(rs.getString(2));
                b.setMovieGenre(rs.getString(3));
                b.setMovieYear(rs.getString(4));
                b.setImageName(rs.getString(5));
                b.setUrlYoutube(rs.getString(6));
                list.add(b);
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
