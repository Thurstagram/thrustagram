package umc.thurstagram.web.dto.commentDTO;

import lombok.Builder;
import lombok.Getter;

public class CommentResponseDTO {

    @Getter
    @Builder
    public static class PostCommentDTO{

        String memberId;
        String profile_img;
        String contents;

    }
}
