package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {


    @Autowired
    MovieService movieService;
    @PostMapping("add-movie")
    public ResponseEntity<Movie> addMovie(@RequestBody() Movie movie){

        movieService.insertMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED );
    }


    @PostMapping("add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){



        movieService.insertDirector(director);
        return new ResponseEntity<>("Success", HttpStatus.CREATED );
    }



    @PostMapping ("add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("name1") String name1, @RequestParam("name2")String name2 ){

        movieService.insertMovieDirector(name1, name2);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }



    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathParam("name") String name){
        return new ResponseEntity<>(movieService.getMovieByName(name) , HttpStatus.OK );
    }


    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathParam("name") String name){
        return new ResponseEntity<>(movieService.getDirectorByName(name) , HttpStatus.OK);
    }



    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathParam("name") String name){
        return new ResponseEntity<>(movieService.getMovieListByDirectorName(name) , HttpStatus.OK);
    }


    @GetMapping("get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies(){
        return new ResponseEntity<>(movieService.getListOfMovies(), HttpStatus.OK);
    }


    @DeleteMapping("delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("name") String name){
        movieService.deleteDirectorByName(name);
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }



    @DeleteMapping("delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
