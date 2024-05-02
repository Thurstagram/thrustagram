package umc.thurstagram.service.pagingService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.thurstagram.converter.PostConverter;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;
import umc.thurstagram.repository.MemberRepository;
import umc.thurstagram.repository.PostHashtagRepository;
import umc.thurstagram.repository.PostImageRepository;
import umc.thurstagram.repository.PostRepository;
import umc.thurstagram.dto.PostResponseDTO;


@Service
public class FeedQueryServiceImpl implements FeedQueryService{

    private MemberRepository memberRepository;
    private PostRepository postRepository;
    private PostImageRepository postImageRepository;
    private PostHashtagRepository postHashtagRepository;


    @Override
    public Page<PostResponseDTO.PostDTO> paging(Long memberId, Pageable pageable) {

        int page = pageable.getPageNumber() -1;

        Member member = memberRepository.findById(memberId).get();

        Page<Post> postPages = postRepository.findAllByMember(member, PageRequest.of(page,15)); // 페이징

        Page<PostResponseDTO.PostDTO> feedListDTO = postPages.map(
                postPage -> PostConverter.toPostDTO(postPage,
                        postHashtagRepository.findByPost(postPage).getHashtag().getName(),
                        postImageRepository.getPostImageByPostId(postPage.getId()).getImgUrl()));

        return feedListDTO;
    }
}
