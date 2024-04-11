package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.PostLike;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
}
