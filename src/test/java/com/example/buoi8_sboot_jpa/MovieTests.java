package com.example.buoi8_sboot_jpa;

import com.example.buoi8_sboot_jpa.entity.Blog;
import com.example.buoi8_sboot_jpa.entity.Movie;
import com.example.buoi8_sboot_jpa.model.enums.MovieType;
import com.example.buoi8_sboot_jpa.repository.BlogRepository;
import com.example.buoi8_sboot_jpa.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Temporal;

import java.util.List;

@SpringBootTest
public class MovieTests {
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private BlogRepository blogRepository;

//    @Test
//    PageRequest pageRequest = PageRequest.of(1, 10);
//    Page<Movie> pageData = movieRepository.findByTypeAndStatusNQ(MovieType.PHIM_BO, true, pageRequest );
//    @Test
//
//        void test_findByStatusAndOrderByPublishedAtDesc(){
//        PageRequest pageRequest = PageRequest.of(1, 4, Sort.by("publishedAt").descending());
//        Page<Blog> pageBlog = blogRepository.findByStatusAndOrderByPublishedAtDesc(true, pageRequest );
//        System.out.println(pageBlog.getContent().size());
//    }


}
