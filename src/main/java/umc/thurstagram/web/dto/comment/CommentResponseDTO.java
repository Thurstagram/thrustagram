package umc.thurstagram.web.dto.comment;

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
