package com.example.buoi8_sboot_jpa.repository;

import com.example.buoi8_sboot_jpa.entity.Genre;
import com.example.buoi8_sboot_jpa.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository  extends JpaRepository<Genre, Integer > {
}
