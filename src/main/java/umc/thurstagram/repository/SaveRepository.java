package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Save;

import java.util.List;

public interface SaveRepository extends JpaRepository<Save, Long> {

    List<Save> findAllByMember_Id(Long memberId);
}
