package umc.thurstagram.dto.response;

import lombok.Getter;

@Getter
public class LikeCreateResponse {

    private Long id;

    public LikeCreateResponse(Long id) {
        this.id = id;
    }
}
