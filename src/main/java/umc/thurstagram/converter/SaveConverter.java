package umc.thurstagram.converter;

import umc.thurstagram.domain.Save;
import umc.thurstagram.web.dto.response.SaveCreateResponse;

public class SaveConverter {

    public static SaveCreateResponse toSaveCreateResponse(Save save) {
        return SaveCreateResponse.builder()
                .saveId(save.getId())
                .build();
    }
}
