package com.example.buoi8_sboot_jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;

    @Column(columnDefinition = "TEXT")
    String content;
    Integer rating;
    @Transient //khoong tao trong database
    String ratingText;
    Date createdAt;
    Date updatedAt;

//    public String getRatingText() {
//        if (rating == null) {
//            return "Chưa có đánh giá";
//        }
//        return switch (rating) {
//            case 1 -> "Tệ";
//            case 2 -> "Không hay";
//            case 3 -> "Bình thường";
//            case 4 -> "Hay";
//            case 5 -> "Tuyệt vời";
//
//            default -> "Chưa có đánh giá";
//        };
//    }
public String getRatingText() {
    if (rating == null) {
        return "Chưa có đánh giá";
    }

    // switch rating from 1 to 10
    return switch (rating) {
        case 1 -> "Tệ";
        case 2 -> "Kém";
        case 3 -> "Trung bình";
        case 4 -> "Tạm được";
        case 5 -> "Hay";
        case 6 -> "Rất hay";
        case 7 -> "Tuyệt vời";
        case 8 -> "Tuyệt hảo";
        case 9 -> "Xuất sắc";
        case 10 -> "Quá tuyệt vời";
        default -> "Chưa có đánh giá";
    };
}
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

}
