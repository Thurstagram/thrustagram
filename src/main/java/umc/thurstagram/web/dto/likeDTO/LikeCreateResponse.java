package umc.thurstagram.web.dto.likeDTO;

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
