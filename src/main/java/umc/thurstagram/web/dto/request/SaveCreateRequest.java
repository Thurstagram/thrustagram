package umc.thurstagram.web.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveCreateRequest {

    private Long memberId;
    private Long postId;

    public SaveCreateRequest(Long memberId, Long postId) {
        this.memberId = memberId;
        this.postId = postId;
    }
}
