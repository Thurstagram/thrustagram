package umc.thurstagram.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.web.dto.commentDTO.CommentCreateRequest;
import umc.thurstagram.web.dto.commentDTO.CommentCreateResponse;
import umc.thurstagram.service.CommentService;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("{postId}/comment")
    public ApiResponse<CommentCreateResponse> writeComment(
            @PathVariable Long postId,
            @RequestBody CommentCreateRequest commentCreateRequest){
        return ApiResponse.onSuccess(commentService.writeComment(postId, commentCreateRequest));
    }

    @DeleteMapping("/{commentId}")
    public ApiResponse<?> deleteComment(@PathVariable Long commentId){
        commentService.deleteByCommentId(commentId);
        return ApiResponse.onSuccess("댓글 삭제됨");
    }

    @PostMapping("{commentId}/recomment")
    public ApiResponse<CommentCreateResponse> writeRecomment(
            @PathVariable Long commentId,
            @RequestBody CommentCreateRequest commentCreateRequest){
        return ApiResponse.onSuccess(commentService.writeRecomment(commentId, commentCreateRequest));
    }

    @DeleteMapping("/{recommentId}")
    public ApiResponse<?> deleteRecomment(@PathVariable Long recommentId){
        commentService.deleteByRecommentId(recommentId);
        return ApiResponse.onSuccess("댓글 삭제됨");
    }
}
