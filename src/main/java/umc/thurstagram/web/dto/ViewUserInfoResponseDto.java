package umc.thurstagram.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewUserInfoResponseDto {
    private String profileImg;
    private String name;
    private String nickname;
}
