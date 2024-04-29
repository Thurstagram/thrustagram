package umc.thurstagram.converter;

import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.PostLike;
import umc.thurstagram.web.dto.post.PostResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PostConverter {

    public static List<PostResponseDTO.PostLikeDTO> toLikeMembersByMembers(List<Member> members){    // 동네형이 받은 리뷰 리스트 조회
        return members.stream()
                .map(member -> PostResponseDTO.PostLikeDTO.builder()
                        .memberId(member.getNickname())
                        .profile_img(member.getProfile_img())
                        .build()).collect(Collectors.toList());
    }

}
