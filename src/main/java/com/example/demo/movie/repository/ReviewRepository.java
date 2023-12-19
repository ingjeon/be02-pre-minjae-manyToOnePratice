package com.example.demo.movie.repository;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
