package umc.thurstagram.service.postLIkeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.domain.Member;
import umc.thurstagram.repository.PostLikeRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostLikeServiceImpl implements PostLikeService {

    private final PostLikeRepository postLikeRepository;

    @Override
    @Transactional
    public List<Member> getMembesrByPostId(Long postId){
        return postLikeRepository.findMembersByPostId(postId);
    }
}
