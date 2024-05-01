package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.PostImage;
import umc.thurstagram.dto.ViewPostsInlineResponseDto;
import umc.thurstagram.repository.PostImageRepository;
import umc.thurstagram.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;

    @Transactional
    public List<ViewPostsInlineResponseDto> viewPostsInline(Long memberId) {
        List<Post> posts =  postRepository.findAllByMember_Id(memberId);
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
