package umc.thurstagram.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostByPostId(Long postId);
    Post findPostByMemberId(Long memberId);

    Page<Post> findAllByMember(Member member, PageRequest pageRequest);

    List<Post> findAllByMemberId(Long memberId);


}
