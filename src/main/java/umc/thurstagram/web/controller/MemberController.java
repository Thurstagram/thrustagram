package umc.thurstagram.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.converter.MemberConverter;
import umc.thurstagram.domain.Member;
import umc.thurstagram.web.dto.profileDTO.UpdateProfileRequestDto;
import umc.thurstagram.web.dto.profileDTO.UpdateProfileResponseDto;
import umc.thurstagram.web.dto.profileDTO.ViewUserInfoResponseDto;
import umc.thurstagram.web.dto.profileDTO.ViewUserNumInfoResponseDto;
import umc.thurstagram.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PatchMapping("/mypage")
    public ApiResponse<UpdateProfileResponseDto> updateProfile(@RequestBody UpdateProfileRequestDto updateProfileRequestDto) {
        Member member = memberService.updateProfile(updateProfileRequestDto);
        UpdateProfileResponseDto updateProfileResponseDto = MemberConverter.toUpdateProfile(member);
        return ApiResponse.onSuccess(updateProfileResponseDto);
    }

    @GetMapping("/members/{memberId}")
    public ApiResponse<ViewUserInfoResponseDto> viewUserInfo(@PathVariable Long memberId) {
        Member member = memberService.viewUserInfo(memberId);
        ViewUserInfoResponseDto viewUserInfoResponseDto = MemberConverter.toViewUserInfo(member);
        return ApiResponse.onSuccess(viewUserInfoResponseDto);
    }

    @GetMapping("/members/{memberId}/numInfo")
    public ApiResponse<ViewUserNumInfoResponseDto> viewUserNumInfo(@PathVariable Long memberId) {
        ViewUserNumInfoResponseDto viewUserNumInfoResponseDto = memberService.viewUserNumInfo(memberId);
        return ApiResponse.onSuccess(viewUserNumInfoResponseDto);
    }
}
