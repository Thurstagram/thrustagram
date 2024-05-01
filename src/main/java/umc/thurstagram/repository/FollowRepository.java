package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Follow;

import java.util.List;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Long countByAcceptor_Id(Long memberId);
    Long countByFollower_Id(Long memberId);

    List<Follow> findAllByAcceptor_Id(Long memberId);
    List<Follow> findAllByFollower_Id(Long memberId);
}
