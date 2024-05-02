package umc.thurstagram.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewFollowResponseDto {
    private Long memberId;
    private String name;
    private String nickname;
    private String profileImg;
}

