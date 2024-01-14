package com.example.buoi8_sboot_jpa.repository;

import com.example.buoi8_sboot_jpa.entity.Actor;
import com.example.buoi8_sboot_jpa.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository  extends JpaRepository<Actor, Integer > {
}
