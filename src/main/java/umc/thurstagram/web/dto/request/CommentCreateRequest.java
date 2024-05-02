package umc.thurstagram.web.dto.request;

import lombok.Getter;

@Getter
public class CommentCreateRequest {

    private Long memberId;
    private String content;

    public CommentCreateRequest(Long memberId, String content) {
        this.memberId = memberId;
        this.content = content;
    }
}
