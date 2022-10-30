package com.driver;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MovieRepository {

    HashMap<String, Movie> MovieMap = new HashMap<>();
    HashMap<String, Director> DirectorMap = new HashMap<>();
    HashMap<Movie, Director> MovieDirectorMap = new HashMap<>();

    void mapMovieDirector(String mov_name, String dir_name){
        Movie movie = MovieMap.get(mov_name);
        Director director = DirectorMap.get(dir_name);
        MovieDirectorMap.put(movie,director);
    }
    void addMovieInDatabase(String name, Movie movie){
        MovieMap.put(name,movie);
    }
    void addDirectorInDatabase(String name, Director director){
        DirectorMap.put(name,director );
    }
    public Movie getMovieByNameDB(String name){
        return MovieMap.get(name);
    }
    public Director getDirectorByNameDB(String name){
        return DirectorMap.get(name);
    }
    public List<String> getMoviesByDirectorName(String name){
        List<String> movieList = new ArrayList<>();
        for(Map.Entry<Movie, Director> movieDirectorEntry: MovieDirectorMap.entrySet()){
            if(movieDirectorEntry.getValue().getName().equals(name)){
                movieList.add(movieDirectorEntry.getKey().getName());
            }
        }
        return movieList;
    }
    public List<Movie> getMoviesListFromDB(){
        List<Movie> movieList = new ArrayList<>();
        for (Map.Entry<String, Movie> movieEntry: MovieMap.entrySet()){
            movieList.add(movieEntry.getValue());
        }
        return movieList;
    }
    public void deleteDirectorByNameDB(String name){
        DirectorMap.remove(name);
        for(Movie key: MovieDirectorMap.keySet()){
            if (MovieDirectorMap.get(key).getName().equals(name)){
                MovieMap.remove(key.getName());
                MovieDirectorMap.remove(key);
            }
        }

    }
}
