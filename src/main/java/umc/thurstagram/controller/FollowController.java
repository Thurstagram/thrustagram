package umc.thurstagram.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import umc.thurstagram.apipayload.ApiResponse;
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

}
