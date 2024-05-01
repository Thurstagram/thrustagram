package umc.thurstagram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.converter.MemberConverter;
import umc.thurstagram.domain.Member;
import umc.thurstagram.dto.UpdateProfileRequestDto;
import umc.thurstagram.dto.UpdateProfileResponseDto;
import umc.thurstagram.service.MemberService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
}
