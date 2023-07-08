package com.dao;

import java.util.List;

import com.entity.MoviesDetails;

public interface MovieDAO {

    public boolean addMovies(MoviesDetails b);

    public List<MoviesDetails> getAllMovies();

    public MoviesDetails  getMovieById(int id);

    public boolean updateEditMovies(MoviesDetails b);

    public boolean deleteMovies(int id);

    public List<MoviesDetails> getActionMovie();

    public List<MoviesDetails> getAdventureMovie();
    public List<MoviesDetails> getFamilyMovie();

    public List<MoviesDetails> getHorrorMovie();
    public List<MoviesDetails> getThrillerMovie();

    public List<MoviesDetails> getMovieBySearch(String ch);
}
