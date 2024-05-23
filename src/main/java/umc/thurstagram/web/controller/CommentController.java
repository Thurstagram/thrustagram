package umc.thurstagram.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.web.dto.commentDTO.CommentCreateRequest;
import umc.thurstagram.web.dto.commentDTO.CommentCreateResponse;
import umc.thurstagram.service.CommentService;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("{postId}/comment")
    public ResponseEntity<CommentCreateResponse> writeComment(
            @PathVariable Long postId,
            @RequestBody CommentCreateRequest commentCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.writeComment(postId, commentCreateRequest));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId){
        commentService.deleteByCommentId(commentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("{commentId}/recomment")
    public ResponseEntity<CommentCreateResponse> writeRecomment(
            @PathVariable Long commentId,
            @RequestBody CommentCreateRequest commentCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.writeRecomment(commentId, commentCreateRequest));
    }

    @DeleteMapping("/{recommentId}")
    public ResponseEntity<?> deleteRecomment(@PathVariable Long recommentId){
        commentService.deleteByRecommentId(recommentId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
