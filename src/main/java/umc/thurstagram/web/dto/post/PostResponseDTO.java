package umc.thurstagram.web.dto.post;

import lombok.Builder;
import lombok.Getter;
import umc.thurstagram.domain.PostImage;
import umc.thurstagram.web.dto.comment.CommentResponseDTO;

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

    }


    @Getter
    @Builder
    public static class PostLikeDTO{
        String memberId;
        String profile_img;
    }

    Getter
    @Builder
    public static class PostDTO{
        String profile_img;
        String contents;

    }


}
