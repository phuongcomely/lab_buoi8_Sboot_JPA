package com.example.buoi8_sboot_jpa.repository;

import com.example.buoi8_sboot_jpa.entity.Movie;
import com.example.buoi8_sboot_jpa.model.enums.MovieType;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

//đối tượng thao tác với csdl
//thao tac voi doi tuong movie  và kiểu du lieu cua khoa chinh doi tuong do. vd Integer id
public interface MovieRepository  extends JpaRepository<Movie, Integer > {

    // tìm kiếm phim theo tiêu dde
    List<Movie> findByTitle(String title);

    // timf kiếm phim theo tiêu đề có từ khóa
    List<Movie> findByTitleContaining(String title);

    // kiếm tra phim có tồn tại theo tiêu đề
    boolean existsByTitle(String title);

    // đếm số lượng phim theo tiêu đề
    long countByTitle(String title);

    //tìm kiếm phim theo tiêu đề và trạng thái
    List<Movie> findByStatusAndType(boolean status, MovieType type);

    //sắp xếp các bộ phim theo view giảm dần
    List<Movie> findAllByOrderByViewDesc();

    // tìm kiếm phim theo trạng thái và sắp xếp theo tiêu chí nào đó
    List<Movie> findByStatus(boolean status, Sort sort);

    List<Movie> findByTypeAndStatusOrderByPublishedAtDesc(MovieType type, boolean status);

    List<Movie> findByTypeAndStatus(MovieType type, boolean status, Sort sort);
    Optional<Movie> findByTypeAndIdAndSlug(MovieType type, int id, String slug);
}
