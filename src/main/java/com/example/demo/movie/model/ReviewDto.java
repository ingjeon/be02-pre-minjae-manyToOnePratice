package com.example.demo.movie.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ReviewDto {
    Integer id;

    Integer star;

    String text;

    MovieDto movieDto;
}
