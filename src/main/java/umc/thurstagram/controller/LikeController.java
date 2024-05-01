package umc.thurstagram.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.dto.request.LikeCreateRequest;
import umc.thurstagram.dto.response.LikeCreateResponse;
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
    public ResponseEntity<?> unlikePost(@PathVariable Long postLikeId){
        likeService.unlikePost(postLikeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{commentId}/like")
    public ResponseEntity<LikeCreateResponse> likeComment(
            @PathVariable Long commentId,
            @RequestBody LikeCreateRequest likeCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(likeService.likeComment(commentId, likeCreateRequest));
    }

    @DeleteMapping("/{commentLikeId}")
    public ResponseEntity<?> unlikeComment(@PathVariable Long commentLikeId){
        likeService.unlikeComment(commentLikeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{recommentId}/like")
    public ResponseEntity<LikeCreateResponse> likeRecomment(
            @PathVariable Long recommentId,
            @RequestBody LikeCreateRequest likeCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(likeService.likeRecomment(recommentId, likeCreateRequest));
    }

    @DeleteMapping("/{recommentLikeId}")
    public ResponseEntity<?> unlikeRecomment(@PathVariable Long recommentLikeId){
        likeService.unlikeRecomment(recommentLikeId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
