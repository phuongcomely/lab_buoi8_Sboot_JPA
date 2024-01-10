package com.example.buoi8_sboot_jpa;

import com.example.buoi8_sboot_jpa.entity.Movie;
import com.example.buoi8_sboot_jpa.model.enums.MovieType;
import com.example.buoi8_sboot_jpa.repository.MovieRepository;
import com.github.javafaker.Faker;
import com.github.slugify.Slugify;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class Buoi8SBootJpaApplicationTests {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void save_all_movie() {
        Faker faker = new Faker();
        Slugify slugify = Slugify.builder().build();

        for (int i = 0; i < 100; i++) {
            boolean status = faker.bool().bool();
            Date createdAt = faker.date().birthday();
            Date updatedAt = null;
            Date publishedAt = status ? createdAt : null;

            String title = faker.book().title();
            Movie movie = Movie.builder()
                    .title(title)
                    .slug(slugify.slugify(title))
                    .description(faker.lorem().paragraph())
                    .poster(faker.company().logo())
                    .type(MovieType.values()[faker.number().numberBetween(0, 3)])
                    .releaseYear(faker.number().numberBetween(2018, 2023))
                    .status(status)
                    .rating(faker.number().numberBetween(1, 10))
                    .view(faker.number().numberBetween(100, 1000))
                    .createdAt(createdAt)
                    .updatedAt(updatedAt)
                    .publishedAt(publishedAt)
                    .build();

            movieRepository.save(movie); // Lưu vào cơ sở dữ liệu
        }
    }

    @Test
    void test_method(){
        Optional<Movie> optionalMovie = movieRepository.findByTypeAndIdAndSlug(MovieType.PHIM_LE, 2, "number-the-stars");
        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            // Continue processing with the movie
            System.out.println(movie);
        } else {
            // Handle the case when the movie is not found
            System.out.println("Movie not found");
        }
//        List<Movie> movies = movieRepository.findAll();
//        System.out.println(movies.size());
//
//        List<Movie> movies1 = movieRepository.findAllById(List.of(1, 2, 3, 1000));
//        System.out.println(movies1.size());



//        Movie movie = movieRepository.findById(1).orElse(null);
//        System.out.println(movie);
//
//        movie.setTitle("Nhà bà nu");
//        movieRepository.save(movie);
//
//        movieRepository.delete(movie);
//        movieRepository.deleteById(2);

    }



}
