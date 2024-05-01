package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    Long countByMember_Id(Long memberId);
    List<Post> findAllByMember_Id(Long memberId);
}
