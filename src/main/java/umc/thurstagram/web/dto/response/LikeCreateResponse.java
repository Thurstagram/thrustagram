package umc.thurstagram.web.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class LikeCreateResponse {

    private LocalDateTime updatedAt;

    public LikeCreateResponse(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
