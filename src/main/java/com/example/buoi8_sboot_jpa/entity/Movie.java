package com.example.buoi8_sboot_jpa.entity;

import com.example.buoi8_sboot_jpa.model.enums.MovieType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String title; //nhà bà nu
    String slug; //nha-ba-nu

    @Column(columnDefinition = "TEXT")
    String description;
    String poster;

    @Enumerated(EnumType.STRING)
    MovieType type;
    Integer  releaseYear;
    Boolean status;
    Integer rating;
    Integer view;

    Date createdAt;
    Date updatedAt;
    Date publishedAt;
}
