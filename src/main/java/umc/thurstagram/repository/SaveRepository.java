package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Save;

public interface SaveRepository extends JpaRepository<Save, Long> {
}
