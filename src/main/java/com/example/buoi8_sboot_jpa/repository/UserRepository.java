package com.example.buoi8_sboot_jpa.repository;

import com.example.buoi8_sboot_jpa.entity.Movie;
import com.example.buoi8_sboot_jpa.entity.User;
import com.example.buoi8_sboot_jpa.model.enums.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Integer > {
    List<User> findByRole(UserRole userRole);

    @Override
    Optional<User> findById(Integer integer);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
