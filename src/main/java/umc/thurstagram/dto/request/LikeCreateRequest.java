package umc.thurstagram.dto.request;

import lombok.Getter;

@Getter
public class LikeCreateRequest {

    private Long memberId;

    public LikeCreateRequest(Long memberId) {
        this.memberId = memberId;
    }
}
