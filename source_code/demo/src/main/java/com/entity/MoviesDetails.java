package com.entity;

public class MoviesDetails {

    private int movieId;
    private String movieTitle;
    private String movieGenre;
    private String movieYear;
    private String imageName;
    private String adminEmail;
    private String urlYoutube;

    public MoviesDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public MoviesDetails(String movieTitle, String movieGenre, String movieYear, String imageName, String adminEmail, String urlYoutube) {
        super();
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
        this.movieYear = movieYear;
        this.imageName = imageName;
        this.adminEmail = adminEmail;
        this.urlYoutube = urlYoutube;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieYear() {
        return movieYear;
    }

    public void setMovieYear(String movieYear) {
        this.movieYear = movieYear;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getUrlYoutube() {
        return urlYoutube;
    }

    public void setUrlYoutube(String urlYoutube) {
        this.urlYoutube = urlYoutube;
    }

    @Override
    public String toString() {
        return "MoviesDetails [movieId=" + movieId + ", movieTitle=" + movieTitle + ", movieGenre=" + movieGenre
                + ", movieYear=" + movieYear + ", imageName=" + imageName + ", adminEmail=" + adminEmail + ", urlYoutube=" + urlYoutube + "]";
    }

}
