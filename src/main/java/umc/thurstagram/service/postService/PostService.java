package umc.thurstagram.service.postService;

import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;
import umc.thurstagram.web.dto.postDTO.ViewPostsInlineResponseDto;
import umc.thurstagram.web.dto.postDTO.PostRequestDTO;

import java.util.List;

public interface PostService {

    public Post getPost(Long postId);

    public void CreateFeed(Member member, PostRequestDTO.PostFeedDTO postFeedDTO);

    public Post getPostByMemberId(Long memberId);

    List<Post> getPostsByMemberId(Long memberId);
    public List<ViewPostsInlineResponseDto> viewPostsInline(Long memberId);
}
