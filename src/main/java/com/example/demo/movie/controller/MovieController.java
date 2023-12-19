package com.example.demo.movie.controller;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.model.MovieDto;
import com.example.demo.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {
    MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(MovieDto movieDto) {
        movieService.create(movieDto);

        return ResponseEntity.ok().body("생성");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {

        return ResponseEntity.ok().body(movieService.list());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(Integer id) {

        return ResponseEntity.ok().body(movieService.read(id));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(MovieDto movieDto) {
        movieService.update(movieDto);

        return ResponseEntity.ok().body("수정");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity delete(Integer id) {
        movieService.delete(id);
        return ResponseEntity.ok().body("삭제");
                
    }
}
