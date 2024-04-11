package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.PostHashtag;

public interface PostHashtagRepository extends JpaRepository<PostHashtag, Long> {
}
