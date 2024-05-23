package umc.thurstagram.web.dto.saveDTO;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveCreateResponse {

    private final Long saveId;

    public SaveCreateResponse(Long saveId) {
        this.saveId = saveId;
    }
}
