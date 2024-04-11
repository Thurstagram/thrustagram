package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
