package umc.thurstagram.converter;

import umc.thurstagram.domain.Comment;
import umc.thurstagram.domain.Member;
import umc.thurstagram.web.dto.comment.CommentResponseDTO;
import umc.thurstagram.web.dto.post.PostResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CommnetConverter {

    public static List<CommentResponseDTO.PostCommentDTO> toPostCommentDTO(List<Comment> comments){

        return comments.stream()
                .map(comment -> CommentResponseDTO.PostCommentDTO.builder()
                        .memberId(comment.getMember().getNickname())
                        .profile_img(comment.getMember().getProfile_img())
                        .contents(comment.getContent())
                        .build()).collect(Collectors.toList());
    }

}
