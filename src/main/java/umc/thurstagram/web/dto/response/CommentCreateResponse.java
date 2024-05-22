package umc.thurstagram.web.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class CommentCreateResponse {

    private final LocalDateTime updatedAt;

    public CommentCreateResponse(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
