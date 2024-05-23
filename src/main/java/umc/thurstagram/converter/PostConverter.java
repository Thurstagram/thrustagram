package umc.thurstagram.converter;

import umc.thurstagram.domain.*;
import umc.thurstagram.web.dto.commentDTO.CommentResponseDTO;
import umc.thurstagram.web.dto.postDTO.PostRequestDTO;
import umc.thurstagram.web.dto.postDTO.PostResponseDTO;

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
                .created_at(post.getCreated_at())
                .build();

    }

    public static Post toPost(PostRequestDTO.PostFeedDTO postFeedDTO, Member member){

        return Post.builder()
                .content(postFeedDTO.getContents())
                .member(member)
                .build();
    }


    //페이징 한 Post DTO 만들기
    public static PostResponseDTO.PostDTO toPostDTO(Post post, String hashTag, String postImg){


        return PostResponseDTO.PostDTO.builder()
                .contents(post.getContent())
                .created_at(post.getCreated_at())
                .hashTag(hashTag)
                .post_img(postImg)
                .build();

    }



}
