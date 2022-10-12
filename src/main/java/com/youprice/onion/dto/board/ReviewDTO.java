package com.youprice.onion.dto.board;

import com.youprice.onion.entity.board.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDTO {

    private Long reviewId; // 리뷰번호 PK
    private Long orderId; // 주문번호 FK
    private String reviewContent; // 리뷰내용
    private Integer grade; // 평점
    private LocalDateTime reviewDate; //등록일

    public ReviewDTO(Review review) {
        this.reviewId = review.getId();
        this.orderId = review.getOrder().getId();
        this.reviewContent = review.getReviewContent();
        this.grade = review.getGrade();
        this.reviewDate = review.getReviewDate();
    }
}