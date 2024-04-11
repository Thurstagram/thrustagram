package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.CommentLike;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {

}
