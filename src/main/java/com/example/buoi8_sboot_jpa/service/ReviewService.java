package com.example.buoi8_sboot_jpa.service;

import com.example.buoi8_sboot_jpa.entity.Movie;
import com.example.buoi8_sboot_jpa.entity.Review;
import com.example.buoi8_sboot_jpa.entity.User;
import com.example.buoi8_sboot_jpa.exception.BadRequestException;
import com.example.buoi8_sboot_jpa.exception.ResourceNotFoundException;
import com.example.buoi8_sboot_jpa.model.request.UpserReviewRequest;
import com.example.buoi8_sboot_jpa.repository.MovieRepository;
import com.example.buoi8_sboot_jpa.repository.ReviewRepository;
import com.example.buoi8_sboot_jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    public List<Review> getReviewsOfMovie(Integer movieId) {
        return reviewRepository.findByMovie_IdOrderByCreatedAtDesc(movieId);
    }

    public Review createReview(UpserReviewRequest request) {
        // TODO: Giả định current user là user có id = 1. Sau này current user sẽ là user đang login
        Integer currentUserId = 1;
        User currentUser = userRepository.findById(currentUserId) // Kiểm tra xem user có tồn tại không
                .orElseThrow(() -> new ResourceNotFoundException("User không tồn tại"));

        Movie movie = movieRepository.findById(request.getMovieId()) // Kiểm tra xem movie có tồn tại không
                .orElseThrow(() -> new ResourceNotFoundException("Phim không tồn tại"));

        // Tạo review
        Review review = Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .movie(movie)
                .user(currentUser)
                .build();

        // Lưu review vào database
        return reviewRepository.save(review);
    }

    public Review updateReview(Integer id, UpserReviewRequest request) {
        // TODO: Giả định current user là user có id = 1. Sau này current user sẽ là user đang login
        Integer currentUserId = 1;
        User currentUser = userRepository.findById(currentUserId) // Kiểm tra xem user có tồn tại không
                .orElseThrow(() -> new ResourceNotFoundException("User không tồn tại"));

        Movie movie = movieRepository.findById(request.getMovieId()) // Kiểm tra xem movie có tồn tại không
                .orElseThrow(() -> new ResourceNotFoundException("Phim không tồn tại"));

        Review review = reviewRepository.findById(id) // Kiểm tra xem review có tồn tại không
                .orElseThrow(() -> new ResourceNotFoundException("Review không tồn tại"));

        // Kiểm tra xem user có phải là người tạo review không
        if (!review.getUser().getId().equals(currentUser.getId())) {
            throw new BadRequestException("Bạn không có quyền cập nhật review này");
        }

        // Kiểm tra xem review có thuộc movie không
        if (!review.getMovie().getId().equals(movie.getId())) {
            throw new BadRequestException("Review không thuộc phim này");
        }

        // Cập nhật review
        review.setContent(request.getContent());
        review.setRating(request.getRating());

        // Lưu review vào database
        return reviewRepository.save(review);
    }

    public void deleteReview(Integer id) {
        // TODO: Giả định current user là user có id = 1. Sau này current user sẽ là user đang login
        Integer currentUserId = 1;
        User currentUser = userRepository.findById(currentUserId) // Kiểm tra xem user có tồn tại không
                .orElseThrow(() -> new ResourceNotFoundException("User không tồn tại"));

        Review review = reviewRepository.findById(id) // Kiểm tra xem review có tồn tại không
                .orElseThrow(() -> new ResourceNotFoundException("Review không tồn tại"));

        // Kiểm tra xem user có phải là người tạo review không
        if (!review.getUser().getId().equals(currentUser.getId())) {
            throw new BadRequestException("Bạn không có quyền xóa review này");
        }

        // Xóa review
        reviewRepository.delete(review);
    }
}
