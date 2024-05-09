package umc.thurstagram.service.postService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.apipayload.Handler.TempHandler;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.converter.HashtagConverter;
import umc.thurstagram.converter.PostConverter;
import umc.thurstagram.converter.PostHashtagConverter;
import umc.thurstagram.domain.*;
import umc.thurstagram.web.dto.ViewPostsInlineResponseDto;
import umc.thurstagram.repository.*;
import umc.thurstagram.web.dto.PostRequestDTO;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

    private final PostRepository postRepository;
    private final HashTagRepository hashTagRepository;
    private final PostHashtagRepository postHashtagRepository;
    private final MemberRepository memberRepository;
    private final PostImageRepository postImageRepository;

    @Override
    @Transactional
    public Post getPost(Long postId){

        return postRepository.findPostById(postId);
    }

    @Override
    @Transactional
    public void CreateFeed(Member member, PostRequestDTO.PostFeedDTO postFeedDTO) {

        if(postFeedDTO.getPost_img_url() == null)
        {
            throw new TempHandler(ErrorStatus.IMG_NOT_FOUND);
        }
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
    public Post getPostByMemberId(Long memberId) {

        return postRepository.findPostByMemberId(memberId);


    }

    @Override
    public List<Post> getPostsByMemberId(Long memberId) {
        return postRepository.findAllByMemberId(memberId);
    }

    @Override
    @Transactional
    public List<ViewPostsInlineResponseDto> viewPostsInline(Long memberId) {
        List<Post> posts =  postRepository.findAllByMemberId(memberId);
        List<ViewPostsInlineResponseDto> viewPostsInlineResponseDtos = new ArrayList<>();
        for(Post post : posts) {
            PostImage postImage = postImageRepository.findFirstByPost_Id(post.getId());
            String firstPic = postImage.getImgUrl();

            ViewPostsInlineResponseDto viewPostsInlineResponseDto = ViewPostsInlineResponseDto.builder()
                    .postId(post.getId())
                    .firstPic(firstPic)
                    .build();
            viewPostsInlineResponseDtos.add(viewPostsInlineResponseDto);
        }
        return viewPostsInlineResponseDtos;
    }


}
