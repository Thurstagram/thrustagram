package umc.thurstagram.web.dto.response;

import lombok.Getter;

@Getter
public class CommentCreateResponse {

    private final Long id;

    public CommentCreateResponse(Long id) {
        this.id = id;
    }
}
