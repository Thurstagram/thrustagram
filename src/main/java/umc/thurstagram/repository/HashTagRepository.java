package umc.thurstagram.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Hashtag;

public interface HashTagRepository extends JpaRepository<Hashtag, Long> {



}
