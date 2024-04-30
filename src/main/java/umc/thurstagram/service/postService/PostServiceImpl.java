package umc.thurstagram.service.postService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.converter.HashtagConverter;
import umc.thurstagram.converter.PostConverter;
import umc.thurstagram.converter.PostHashtagConverter;
import umc.thurstagram.domain.Hashtag;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.PostHashtag;
import umc.thurstagram.repository.HashTagRepository;
import umc.thurstagram.repository.MemberRepository;
import umc.thurstagram.repository.PostHashtagRepository;
import umc.thurstagram.repository.PostRepository;
import umc.thurstagram.web.controller.PostController;
import umc.thurstagram.web.dto.post.PostRequestDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final HashTagRepository hashTagRepository;
    private final PostHashtagRepository postHashtagRepository;
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Post getPost(Long postId){

        return postRepository.findPostByPostId(postId);
    }

    @Override
    @Transactional
    public void CreateFeed(Member member, PostRequestDTO.PostFeedDTO postFeedDTO) {

        // Save post
        Post post = PostConverter.toPost(postFeedDTO, member);
        postRepository.save(post);

        // Save Hashtag
        Hashtag hashtag = HashtagConverter.toHashtag(postFeedDTO);
        hashTagRepository.save(hashtag);

        // Save PostHashtag
        PostHashtag postHashtag = PostHashtagConverter.toPostHashtag(post,hashtag);
        postHashtagRepository.save(postHashtag);





    }

    @Override
    @Transactional
    public List<Post> getPostsByMemberId(Long memberId) {
        return postRepository.findAllByMemberId(memberId);
    }


}
