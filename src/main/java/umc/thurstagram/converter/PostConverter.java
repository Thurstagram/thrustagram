package umc.thurstagram.converter;

import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.PostLike;
import umc.thurstagram.web.dto.comment.CommentResponseDTO;
import umc.thurstagram.web.dto.post.PostResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PostConverter {

    public static List<PostResponseDTO.PostLikeDTO> toLikeMembersByMembers(List<Member> members){
        return members.stream()
                .map(member -> PostResponseDTO.PostLikeDTO.builder()
                        .memberId(member.getNickname())
                        .profile_img(member.getProfile_img())
                        .build()).collect(Collectors.toList());
    }

    public static PostResponseDTO.PostDetailDTO toPostDetailDTO(List<CommentResponseDTO.PostCommentDTO> commentDTOS, Post post, int size, String UrlImage){

        return PostResponseDTO.PostDetailDTO.builder()
                .postId(post.getId())
                .memberId(post.getMember().getNickname())
                .content(post.getContent())
                .postLike(size)
                .postCommentDTOS(commentDTOS)
                .profile_img(post.getMember().getProfile_img())
                .postImageUrl(UrlImage)
                .build();

    }

}
