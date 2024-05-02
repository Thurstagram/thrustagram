package umc.thurstagram.service.postImageService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.repository.PostImageRepository;

@Service
@RequiredArgsConstructor
public class PostImageServiceImpl implements PostImageService{

    private final PostImageRepository postImageRepository;

    @Override
    @Transactional
    public String getUrlImg(Long postId){

        return postImageRepository.getPostImageByPostId(postId).getImgUrl();
    }
}
