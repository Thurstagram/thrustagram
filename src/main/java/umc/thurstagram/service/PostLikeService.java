package umc.thurstagram.service;

import umc.thurstagram.domain.Member;

import java.util.List;

public interface PostLikeService {

    List<Member> getMembesrByPostId(Long postId);
}
