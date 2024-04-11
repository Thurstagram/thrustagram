package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Recomment;
import umc.thurstagram.domain.RecommentLike;

public interface RecommentLikeRepository extends JpaRepository<RecommentLike, Long> {
}
