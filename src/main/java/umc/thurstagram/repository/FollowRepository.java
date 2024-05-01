package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Long countByAcceptor_Id(Long memberId);
    Long countByFollower_Id(Long memberId);
}
