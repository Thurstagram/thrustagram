package umc.thurstagram.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.thurstagram.domain.Member;

@Getter
@NoArgsConstructor
public class UpdateProfileRequestDto {
    private Long memberId;
    private String profileImg;
    private String name;
    private String nickname;

    @Builder
    public UpdateProfileRequestDto(Member member) {
        this.memberId = member.getId();
        this.profileImg = member.getProfile_img();
        this.name = member.getName();
        this.nickname = member.getNickname();
    }
}
