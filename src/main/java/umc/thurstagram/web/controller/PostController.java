package umc.thurstagram.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.converter.CommnetConverter;
import umc.thurstagram.converter.PostConverter;
import umc.thurstagram.domain.*;
import umc.thurstagram.web.dto.ViewPostsInlineResponseDto;
import umc.thurstagram.service.commentService.CommentService;
import umc.thurstagram.service.memberService.MemberService;
import umc.thurstagram.service.pagingService.FeedQueryService;
import umc.thurstagram.service.postHashtagService.PostHashtagService;
import umc.thurstagram.service.postImageService.PostImageService;
import umc.thurstagram.service.postLIkeService.PostLikeService;
import umc.thurstagram.service.postService.PostService;
import umc.thurstagram.web.dto.CommentResponseDTO;
import umc.thurstagram.web.dto.PostRequestDTO;
import umc.thurstagram.web.dto.PostResponseDTO;

import java.util.List;

@RestController
@RequestMapping("/p")
@RequiredArgsConstructor
public class PostController {

    private final PostLikeService postLikeService;
    private final CommentService commentService;
    private final PostService postService;
    private final PostImageService postImageService;
    private final MemberService memberService;
    private final PostHashtagService postHashtagService;
    private final FeedQueryService feedQueryService;


    @GetMapping("/{postId}")
    public void getDetailPost(@PathVariable(value = "postId") Long postId) {

        List<Comment> PostComments = commentService.getComments(postId);
        //코멘트 받아서  PostCommentDTO 리스트로 바꿔줌
        List<CommentResponseDTO.PostCommentDTO> PostCommentsDTO = CommnetConverter.toPostCommentDTO(PostComments);
        //코멘트 리스트랑 Post 받아서 DTO로 변환해줌
        Post post = postService.getPost(postId);
        //포스트에 좋아요한 숫자
        int postLikes = postLikeService.getMembesrByPostId(postId).size();
        // 포스트 이미지
        String postImgUrl = postImageService.getUrlImg(postId);
        PostResponseDTO.PostDetailDTO postDetailDTO = PostConverter.toPostDetailDTO(PostCommentsDTO, post, postLikes, postImgUrl);

    }
    @GetMapping("/{postId}/likes")
    public void getLikes(@PathVariable(value = "postId") Long postId){

        List<Member> likeMembers = postLikeService.getMembesrByPostId(postId);
        List<PostResponseDTO.PostLikeDTO> postLikeDTOS = PostConverter.toLikeMembersByMembers(likeMembers);

    }

    @PostMapping("/{memberId}")
    public void postFeed(@RequestPart(value = "request") PostRequestDTO.PostFeedDTO postFeedDTO,
                                     @PathVariable(value = "memberId") String memberId){

            Member member = memberService.getMemberByNickname(memberId);
            postService.CreateFeed(member, postFeedDTO);

    }

    @GetMapping("/{memberNickname}")
    public void getMemberPost(@PageableDefault(page = 1) Pageable pageable, @PathVariable(value = "memberNickname") String memberNickname){

        //닉네임으로 멤버 추출 및 멤버아이디 가져옴
        Member member = memberService.getMemberByNickname(memberNickname);
        Long memberId = member.getId(); // 나중에 걍 서비스에서 닉네임으로 아이디 만들기

        Page<PostResponseDTO.PostDTO> feedListDTO = feedQueryService.paging(memberId,pageable);


    }

    @GetMapping("/members/{memberId}/posts")
    public ApiResponse<List<ViewPostsInlineResponseDto>> viewPostsInline(@PathVariable Long memberId) {
        List<ViewPostsInlineResponseDto> viewPostsInlineResponseDtos = postService.viewPostsInline(memberId);
        return ApiResponse.onSuccess(viewPostsInlineResponseDtos);
    }
}
