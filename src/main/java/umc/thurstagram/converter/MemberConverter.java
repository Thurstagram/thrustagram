package umc.thurstagram.converter;

import umc.thurstagram.domain.Member;
import umc.thurstagram.dto.UpdateProfileRequestDto;
import umc.thurstagram.dto.UpdateProfileResponseDto;

public class MemberConverter {
    public static Member toMember(UpdateProfileRequestDto updateProfileRequestDto) {
        return Member.builder()
                .id(updateProfileRequestDto.getMemberId())
                .profile_img(updateProfileRequestDto.getProfileImg())
                .name(updateProfileRequestDto.getName())
                .nickname(updateProfileRequestDto.getNickname())
                .build();
    }

    public static UpdateProfileResponseDto toUpdateProfile(Member member) {
        return UpdateProfileResponseDto.builder()
                .memberId(member.getId())
                .updatedAt(member.getUpdated_at())
                .build();
    }
}
