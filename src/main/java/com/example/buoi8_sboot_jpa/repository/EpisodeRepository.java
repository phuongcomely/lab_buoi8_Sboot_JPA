package com.example.buoi8_sboot_jpa.repository;

import com.example.buoi8_sboot_jpa.entity.Episode;
import com.example.buoi8_sboot_jpa.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository  extends JpaRepository<Episode, Integer > {
}
