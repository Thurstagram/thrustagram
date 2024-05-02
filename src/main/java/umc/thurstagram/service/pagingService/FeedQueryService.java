package umc.thurstagram.service.pagingService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.thurstagram.web.dto.PostResponseDTO;

public interface FeedQueryService {


    Page<PostResponseDTO.PostDTO> paging(Long postId, Pageable pageable);
}
