package umc.thurstagram.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveResponse {

    private Long saveId;
    private Long postId;
    private String imageUrl;

    public SaveResponse(Long saveId, Long postId, String imageUrl) {
        this.saveId = saveId;
        this.postId = postId;
        this.imageUrl = imageUrl;
    }
}
