package umc.thurstagram.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.web.dto.request.LikeCreateRequest;
import umc.thurstagram.web.dto.response.LikeCreateResponse;
import umc.thurstagram.service.LikeService;

@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{postId}/like")
    public ApiResponse<LikeCreateResponse> likePost(
            @PathVariable Long postId,
            @RequestBody LikeCreateRequest likeCreateRequest){
        return ApiResponse.onSuccess(likeService.likePost(postId, likeCreateRequest));
    }

    @DeleteMapping("/{postLikeId}")
    public ApiResponse<?> unlikePost(@PathVariable Long postLikeId){
        likeService.unlikePost(postLikeId);
        return ApiResponse.onSuccess("좋아요 취소됨");
    }

    @PostMapping("/{commentId}/like")
    public ApiResponse<LikeCreateResponse> likeComment(
            @PathVariable Long commentId,
            @RequestBody LikeCreateRequest likeCreateRequest){
        return ApiResponse.onSuccess(likeService.likeComment(commentId, likeCreateRequest));
    }

    @DeleteMapping("/{commentLikeId}")
    public ApiResponse<?> unlikeComment(@PathVariable Long commentLikeId){
        likeService.unlikeComment(commentLikeId);
        return ApiResponse.onSuccess("좋아요 취소됨");
    }

    @PostMapping("/{recommentId}/like")
    public ApiResponse<LikeCreateResponse> likeRecomment(
            @PathVariable Long recommentId,
            @RequestBody LikeCreateRequest likeCreateRequest){
        return ApiResponse.onSuccess(likeService.likeRecomment(recommentId, likeCreateRequest));
    }

    @DeleteMapping("/{recommentLikeId}")
    public ApiResponse<?> unlikeRecomment(@PathVariable Long recommentLikeId){
        likeService.unlikeRecomment(recommentLikeId);
        return ApiResponse.onSuccess("좋아요 취소됨");
    }
}
