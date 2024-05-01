package umc.thurstagram.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.converter.FollowConverter;
import umc.thurstagram.domain.Follow;
import umc.thurstagram.dto.FollowRequestDto;
import umc.thurstagram.dto.FollowResponseDto;
import umc.thurstagram.dto.ViewFollowResponseDto;
import umc.thurstagram.service.FollowService;

import java.util.List;

@RestController
@AllArgsConstructor
public class FollowController {
    private final FollowService followService;

    @GetMapping("/members/{memberId}/followers")
    public ApiResponse<List<ViewFollowResponseDto>> viewFollowers(@PathVariable Long memberId) {
        List<ViewFollowResponseDto> viewFollowResponseDtos = followService.viewFollowers(memberId);
        return ApiResponse.onSuccess(viewFollowResponseDtos);
    }

    @GetMapping("/members/{memberId}/followings")
    public ApiResponse<List<ViewFollowResponseDto>> viewFollowings(@PathVariable Long memberId) {
        List<ViewFollowResponseDto> viewFollowResponseDtos = followService.viewFollowings(memberId);
        return ApiResponse.onSuccess(viewFollowResponseDtos);
    }

    @PostMapping("/members/follow")
    public ApiResponse<FollowResponseDto> follow(@RequestBody FollowRequestDto followRequestDto) {
        Follow f = followService.follow(followRequestDto);
        FollowResponseDto followResponseDto = FollowConverter.toFollowResponse(f);
        return ApiResponse.onSuccess(followResponseDto);
    }

    @DeleteMapping("/members/followCancel")
    public ApiResponse<?> followCancel(@RequestBody FollowRequestDto followRequestDto) {
        followService.followCancel(followRequestDto);
        return ApiResponse.onSuccess("팔로우 취소됨");
    }
}
