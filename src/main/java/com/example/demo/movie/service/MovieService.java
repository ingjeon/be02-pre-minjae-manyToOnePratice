package com.example.demo.movie.service;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.model.MovieDto;
import com.example.demo.movie.model.Review;
import com.example.demo.movie.model.ReviewDto;
import com.example.demo.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void create(MovieDto movieDto) {

        movieRepository.save(Movie.builder()
                .name(movieDto.getName())
                .price(movieDto.getPrice())
                .build());
    }

    public List<MovieDto> list() {
        List<Movie> result = movieRepository.findAll();

        List<MovieDto> movieDtos = new ArrayList<>();
        for (Movie movie : result) {
            List<ReviewDto> reviewDtos = new ArrayList<>();
            List<Review> reviews = movie.getReviews();

            for (Review review : reviews) {
                ReviewDto reviewDto = ReviewDto.builder()
                        .id(review.getId())
                        .text(review.getText())
                        .star(review.getStar())
                        .build();

                reviewDtos.add(reviewDto);
            }

            MovieDto movieDto = MovieDto.builder()
                    .id(movie.getId())
                    .name(movie.getName())
                    .price(movie.getPrice())
                    .reviews(reviewDtos)
                    .build();
            movieDtos.add(movieDto);
        }


        return movieDtos;
    }

    public MovieDto read(Integer id) {
        Optional<Movie> result = movieRepository.findById(id);
        if (result.isPresent()) {
            Movie movie = result.get();

            List<ReviewDto> reviewDtos = new ArrayList<>();

            for (Review review : movie.getReviews()) {
                reviewDtos.add(ReviewDto.builder()
                        .id(review.getId())
                        .star(review.getStar())
                        .text(review.getText())
                        .build()
                );
            }

            return MovieDto.builder()
                    .id(movie.getId())
                    .price(movie.getPrice())
                    .name(movie.getName())
                    .reviews(reviewDtos)
                    .build();
        } else {
            return null;
        }
    }

    public void update(MovieDto movieDto) {
        movieRepository.save(Movie.builder()
                .id(movieDto.getId())
                .name(movieDto.getName())
                .price(movieDto.getPrice())
                .build());
    }

    public void delete(Integer id) {
        movieRepository.delete(Movie.builder().id(id).build());
    }
}
