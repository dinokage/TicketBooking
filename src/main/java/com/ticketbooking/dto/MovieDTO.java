package com.ticketbooking.dto;

public class MovieDTO {

    private int movieId;
    private String movieName;
    private String movieGenre;
    private String movieHours;
    private String movieLanguage;
    private int year;
    private String movieDescription;

    public MovieDTO() {
        // Default constructor
    }

    public MovieDTO(int movieId, String movieName, String movieGenre, String movieHours, String movieLanguage,
                    int year, String movieDescription) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieGenre = movieGenre;
        this.movieHours = movieHours;
        this.movieLanguage = movieLanguage;
        this.year = year;
        this.movieDescription = movieDescription;
    }

    // Getters and setters for all fields

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public String getMovieHours() {
        return movieHours;
    }

    public void setMovieHours(String movieHours) {
        this.movieHours = movieHours;
    }

    public String getMovieLanguage() {
        return movieLanguage;
    }

    public void setMovieLanguage(String movieLanguage) {
        this.movieLanguage = movieLanguage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }
}
