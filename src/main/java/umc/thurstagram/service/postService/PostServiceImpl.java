package umc.thurstagram.service.postService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.domain.Post;
import umc.thurstagram.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;

    @Override
    @Transactional
    public Post getPost(Long postId){

        return postRepository.findPostByPostId(postId);
    }


}
