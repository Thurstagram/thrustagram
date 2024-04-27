package umc.thurstagram.web.dto.peed;

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
        Long postLike;
        List<CommentResponseDTO.PostCommentDTO> postCommentDTOS;
        String profile_img;
        List<PostImage> postImage;

    }

}
