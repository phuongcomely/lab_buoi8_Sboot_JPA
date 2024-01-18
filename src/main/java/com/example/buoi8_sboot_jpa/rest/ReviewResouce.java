package com.example.buoi8_sboot_jpa.rest;

//json: dat tien to /api truoc

import com.example.buoi8_sboot_jpa.entity.Review;
import com.example.buoi8_sboot_jpa.model.request.UpserReviewRequest;
import com.example.buoi8_sboot_jpa.service.ReviewService;
import jdk.jfr.Registered;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/reviews")
@RequiredArgsConstructor //ko can dung toi autowired
public class ReviewResouce {

    private final ReviewService reviewService;
    //tao review: POST
    //Client -> request chuaws thong tin -> server
    //server doc du lieu tu request -> xu ly -> tra ve ket qua cho client
    @PostMapping
    public ResponseEntity<?> createdReview(@RequestBody UpserReviewRequest request){
        Review review = reviewService.createReview(request);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    //Cap nhat review: PUT
    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview(@RequestBody UpserReviewRequest request, @PathVariable Integer id){
        Review review = reviewService.updateReview(id, request);
        return ResponseEntity.ok(review);

    }

    //xoa review: DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReview( @PathVariable Integer id){
       reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();

    }
}
