package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Recomment;

public interface RecommentRepository extends JpaRepository<Recomment, Long> {
}
