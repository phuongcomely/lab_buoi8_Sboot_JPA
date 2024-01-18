package com.example.buoi8_sboot_jpa.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@Getter
@Setter@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpserReviewRequest {
    Integer rating;
    String  content;
    Integer movieId;
}
