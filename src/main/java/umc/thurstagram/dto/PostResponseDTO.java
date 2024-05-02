package umc.thurstagram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.thurstagram.dto.CommentResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public class PostResponseDTO {

    @Getter
    @Builder
    public static class PostDetailDTO{

        Long postId;
        String memberId;
        String content;
        int postLike;
        List<CommentResponseDTO.PostCommentDTO> postCommentDTOS;
        String profile_img;
        String postImageUrl;
        LocalDateTime created_at;


    }


    @Getter
    @Builder
    public static class PostLikeDTO{
        String memberId;
        String profile_img;
    }



    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostDTO{

        String post_img;
        String contents;
        LocalDateTime created_at;
        String hashTag; //일단 포스트 한개당 해시태그가 하나라고 가정


    }


}
