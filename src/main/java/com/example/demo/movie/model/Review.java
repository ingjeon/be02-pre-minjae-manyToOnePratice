package com.example.demo.movie.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer star;

    String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Movie_id")
    Movie movie;

}
