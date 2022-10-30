package com.driver;
//String name, int durationInMinutes, double imdbRating, no-args constructor, all-args constructor and getters-setters
public class Movie {
    String name;
    int durationInMinutes;
    double movieRating;

    Movie(){

    }

    public Movie(String name, int durationInMinutes, double imdbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.movieRating = movieRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getmovieRating() {
        return movieRating;
    }

    public void setmovieRating(double movieRating) {
        this.movieRating = movieRating;
    }
}
