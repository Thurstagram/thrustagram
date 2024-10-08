package umc.thurstagram.converter;

import umc.thurstagram.domain.Member;
import umc.thurstagram.web.dto.profileDTO.UpdateProfileRequestDto;
import umc.thurstagram.web.dto.profileDTO.UpdateProfileResponseDto;
import umc.thurstagram.web.dto.profileDTO.ViewUserInfoResponseDto;

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

    public static ViewUserInfoResponseDto toViewUserInfo(Member member) {
        return ViewUserInfoResponseDto.builder()
                .profileImg(member.getProfile_img())
                .name(member.getName())
                .nickname(member.getNickname())
                .build();
    }
}
