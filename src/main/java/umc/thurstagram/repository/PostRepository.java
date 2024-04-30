package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostByPostId(Long postId);
    List<Post> findAllByMemberId(Long memberId);

}
