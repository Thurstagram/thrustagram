package umc.thurstagram.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.web.dto.request.LikeCreateRequest;
import umc.thurstagram.web.dto.response.LikeCreateResponse;
import umc.thurstagram.service.LikeService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("/{postId}/like")
    public ResponseEntity<LikeCreateResponse> likePost(
            @PathVariable Long postId,
            @RequestBody LikeCreateRequest likeCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(likeService.likePost(postId, likeCreateRequest));
    }

    @DeleteMapping("/{postLikeId}")
    public ApiResponse<?> unlikePost(@PathVariable Long postLikeId){
        likeService.unlikePost(postLikeId);
        return ApiResponse.onSuccess("좋아요 취소됨");
    }

    @PostMapping("/{commentId}/like")
    public ResponseEntity<LikeCreateResponse> likeComment(
            @PathVariable Long commentId,
            @RequestBody LikeCreateRequest likeCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(likeService.likeComment(commentId, likeCreateRequest));
    }

    @DeleteMapping("/{commentLikeId}")
    public ApiResponse<?> unlikeComment(@PathVariable Long commentLikeId){
        likeService.unlikeComment(commentLikeId);
        return ApiResponse.onSuccess("좋아요 취소됨");
    }

    @PostMapping("/{recommentId}/like")
    public ResponseEntity<LikeCreateResponse> likeRecomment(
            @PathVariable Long recommentId,
            @RequestBody LikeCreateRequest likeCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(likeService.likeRecomment(recommentId, likeCreateRequest));
    }

    @DeleteMapping("/{recommentLikeId}")
    public ApiResponse<?> unlikeRecomment(@PathVariable Long recommentLikeId){
        likeService.unlikeRecomment(recommentLikeId);
        return ApiResponse.onSuccess("좋아요 취소됨");
    }
}
