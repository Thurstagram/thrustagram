package umc.thurstagram.converter;

import umc.thurstagram.domain.Save;
import umc.thurstagram.web.dto.saveDTO.SaveCreateResponse;

public class SaveConverter {

    public static SaveCreateResponse toSaveCreateResponse(Save save) {
        return SaveCreateResponse.builder()
                .saveId(save.getId())
                .build();
    }
}
