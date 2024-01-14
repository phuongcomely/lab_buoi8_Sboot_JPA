package com.example.buoi8_sboot_jpa.repository;

import com.example.buoi8_sboot_jpa.entity.Director;
import com.example.buoi8_sboot_jpa.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository  extends JpaRepository<Director, Integer > {
}
