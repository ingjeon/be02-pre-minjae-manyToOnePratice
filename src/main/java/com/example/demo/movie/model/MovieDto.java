package com.example.demo.movie.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class MovieDto {
    Integer id;

    String name;
    Integer price;
    List<ReviewDto> reviews = new ArrayList<>();
}
