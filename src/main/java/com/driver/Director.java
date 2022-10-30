package com.driver;
// String name, int numberOfMovies, double imdbRating, no-args constructor, all-args constructor and getters-setters
public class Director {
    String name;
    int numberOfMovies;
    double movieRating;

    Director(){

    }

    public Director(String name, int numberOfMovies, double movieRating) {
        this.name = name;
        this.numberOfMovies = numberOfMovies;
        this.movieRating = movieRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfMovies() {
        return numberOfMovies;
    }

    public void setNumberOfMovies(int numberOfMovies) {
        this.numberOfMovies = numberOfMovies;
    }

    public double getmovieRating() {
        return movieRating;
    }

    public void setmovieRating(double imdbRating) {
        this.movieRating = movieRating;
    }
}
