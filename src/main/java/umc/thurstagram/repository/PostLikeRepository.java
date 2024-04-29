package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.PostLike;

import java.util.List;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {

    List<Member> findMembersByPostId(Long postId);

}
