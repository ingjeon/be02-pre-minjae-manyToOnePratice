package com.example.demo.movie.controller;

import com.example.demo.movie.model.MovieDto;
import com.example.demo.movie.model.ReviewDto;
import com.example.demo.movie.service.MovieService;
import com.example.demo.movie.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/review")
public class ReviewController {
    ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity create(Integer movieId, ReviewDto reviewDto) {
        reviewService.create(movieId, reviewDto);
        return ResponseEntity.ok().body("생성");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity list() {
        return ResponseEntity.ok().body(reviewService.list());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity read(Integer id) {
        return ResponseEntity.ok().body(reviewService.read(id));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity update(ReviewDto reviewDto) {
        reviewService.update(reviewDto);
        return ResponseEntity.ok().body("수정");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity delete(Integer id) {
        reviewService.delete(id);
        return ResponseEntity.ok().body("삭제");
    }
}
