package umc.thurstagram.service.postHashtagService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.PostHashtag;
import umc.thurstagram.repository.PostHashtagRepository;

@Service
@RequiredArgsConstructor
public class PostHashTagServiceImpl implements PostHashtagService {

    private final PostHashtagRepository postHashtagRepository;

    @Override
    public PostHashtag getPostHashtagByPost(Post post) {
        return postHashtagRepository.findByPost(post);
    }
}
