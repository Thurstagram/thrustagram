package umc.thurstagram.converter;

import java.util.List;
import java.util.stream.Collectors;

public class PostConverter {

    public static List<ReviewResponseDTO.ReviewByCoachDTO> toReviewByCoachDTO(List<Review> reviews){    // 동네형이 받은 리뷰 리스트 조회
        return reviews.stream()
                .map(review -> ReviewResponseDTO.ReviewByCoachDTO.builder()
                        .review_id(review.getId())
                        .nickname(review.getMember().getNickname()) // 회원 닉네임
                        .pictureURL(review.getMember().getPictureURL())
                        .createdAt(review.getCreatedAt())
                        .build()).collect(Collectors.toList());
    }

}
