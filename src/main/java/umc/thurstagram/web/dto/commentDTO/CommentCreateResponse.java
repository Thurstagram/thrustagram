package umc.thurstagram.web.dto.commentDTO;

import lombok.Getter;

@Getter
public class CommentCreateResponse {

    private final Long id;

    public CommentCreateResponse(Long id) {
        this.id = id;
    }
}
