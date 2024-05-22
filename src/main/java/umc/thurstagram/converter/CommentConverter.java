package umc.thurstagram.converter;

import umc.thurstagram.domain.Comment;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.Recomment;
import umc.thurstagram.web.dto.CommentResponseDTO;
import umc.thurstagram.web.dto.request.CommentCreateRequest;

import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {

    public static List<CommentResponseDTO.PostCommentDTO> toPostCommentDTO(List<Comment> comments){

        return comments.stream()
                .map(comment -> CommentResponseDTO.PostCommentDTO.builder()
                        .memberId(comment.getMember().getNickname())
                        .profile_img(comment.getMember().getProfile_img())
                        .contents(comment.getContent())
                        .build()).collect(Collectors.toList());
    }

    public static Comment toComment(Member member, Post post, CommentCreateRequest commentCreateRequest){
        return Comment.builder()
                .member(member)
                .post(post)
                .content(commentCreateRequest.getContent())
                .build();
    }

    public static Recomment toRecomment(Member member, Comment comment, CommentCreateRequest commentCreateRequest){
        return Recomment.builder()
                .member(member)
                .comment(comment)
                .content(commentCreateRequest.getContent())
                .build();
    }
}
