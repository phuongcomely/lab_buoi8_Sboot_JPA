package com.example.buoi8_sboot_jpa.repository;

import com.example.buoi8_sboot_jpa.entity.Movie;
import com.example.buoi8_sboot_jpa.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository  extends JpaRepository<Review, Integer > {
}
