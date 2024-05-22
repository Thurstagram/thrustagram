package umc.thurstagram.web.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SaveCreateResponse {

    private final Long saveId;

    public SaveCreateResponse(Long saveId) {
        this.saveId = saveId;
    }
}
