package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.PostImage;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {

    PostImage findFirstByPost_Id(Long postId);
}
