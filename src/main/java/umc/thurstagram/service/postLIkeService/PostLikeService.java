package umc.thurstagram.service.postLIkeService;

import umc.thurstagram.domain.Member;

import java.util.List;

public interface PostLikeService {

    List<Member> getMembesrByPostId(Long postId);
}
