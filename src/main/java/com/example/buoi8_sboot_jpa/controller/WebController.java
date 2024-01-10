package com.example.buoi8_sboot_jpa.controller;

import com.example.buoi8_sboot_jpa.entity.Movie;
import com.example.buoi8_sboot_jpa.model.enums.MovieType;
import com.example.buoi8_sboot_jpa.repository.MovieRepository;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;


//Định nghĩa 3 controller để xử lý các request từ client:
//        - GET "/phim-le": trả về danh sách phim lẻ (phim có status = true và sắp xếp theo publishedAt giảm dần)
//- GET "/phim-bo": trả về danh sách phim bộ (phim có status = true và sắp xếp theo publishedAt giảm dần)
//- GET "/phim-chieu-rap": trả về danh sách phim chiếu rạp (phim có status = true và sắp xếp theo publishedAt giảm dần)
@Controller
public class WebController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping("/phim-bo")
    public String findByPhimbo(Model model){
        List<Movie> movies = movieRepository.findByTypeAndStatusOrderByPublishedAtDesc( MovieType.PHIM_BO, true);

        model.addAttribute("movies", movies );
        return "web/phim-bo";
    }
    @GetMapping("/phim-le")
    public String findByPhimle(Model model){
        List<Movie> movies1 = movieRepository.findByTypeAndStatusOrderByPublishedAtDesc( MovieType.PHIM_LE, true);

        model.addAttribute("movies1", movies1 );
        System.out.println(movies1.size());
        return "web/phim-le";
    }
    @GetMapping("/phim-chieu-rap")
    public String findByPhimchieurap(Model model){
        List<Movie> movies2 = movieRepository.findByTypeAndStatusOrderByPublishedAtDesc( MovieType.PHIM_CHIEU_RAP, true);

        model.addAttribute("movies2", movies2 );
        return "web/phim-chieu-rap";
    }
    @GetMapping("/phim/{id}/{slug}")
    public String findById(Model model, @PathVariable int id,   @PathVariable String slug){

        Optional<Movie> optionalMovie = movieRepository.findByTypeAndIdAndSlug(MovieType.PHIM_LE, id, slug);

        if (optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            model.addAttribute("movie", movie);
            return "web/Movie-detail";
        } else {
            return "web/Movie-not-found"; // Điều hướng đến trang thông báo không tìm thấy nếu không có phim
        }
    }
}
