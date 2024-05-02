package umc.thurstagram.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.domain.Post;
import umc.thurstagram.dto.ViewPostsInlineResponseDto;
import umc.thurstagram.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/members/{memberId}/posts")
    public ApiResponse<List<ViewPostsInlineResponseDto>> viewPostsInline(@PathVariable Long memberId) {
        List<ViewPostsInlineResponseDto> viewPostsInlineResponseDtos = postService.viewPostsInline(memberId);
        return ApiResponse.onSuccess(viewPostsInlineResponseDtos);
    }
}
