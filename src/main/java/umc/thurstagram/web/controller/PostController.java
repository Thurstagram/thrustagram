package umc.thurstagram.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.converter.PostConverter;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.PostLike;
import umc.thurstagram.service.PostLikeService;
import umc.thurstagram.service.PostLikeServiceImpl;
import umc.thurstagram.web.dto.post.PostResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/p")
@RequiredArgsConstructor
public class PostController {

    private final PostLikeService postLikeService;


    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDTO.PostDetailDTO> getDetailPost(@PathVariable(value = "postId") Long postId) {

        return
    }
    @GetMapping("/{postId}/likes")
    public ResponseEntity<List<PostResponseDTO.PostLikeDTO>> getLikes(@PathVariable(value = "postId") Long postId){

        List<Member> likeMembers = postLikeService.getMembesrByPostId(postId);
        List<PostResponseDTO.PostLikeDTO> postLikeDTOS = PostConverter.toLikeMembersByMembers(likeMembers);

        return
    }

    @PostMapping("")
    public ResponseEntity<> postFeed()
}
