package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.domain.*;
import umc.thurstagram.web.dto.request.LikeCreateRequest;
import umc.thurstagram.web.dto.response.LikeCreateResponse;
import umc.thurstagram.repository.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class LikeService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final RecommentRepository recommentRepository;
    private final PostLikeRepository postLikeRepository;
    private final CommentLikeRepository commentLikeRepository;
    private final RecommentLikeRepository recommentLikeRepository;

    @Transactional
    public LikeCreateResponse likePost(Long postId, LikeCreateRequest likeCreateRequest){

        Member member = memberRepository.findById(likeCreateRequest.getMemberId())
                .orElseThrow();
        Post post = postRepository.findById(postId)
                .orElseThrow();

        PostLike postLike = postLikeRepository.save(PostLike.of(member, post));
        return new LikeCreateResponse(postLike.getId());
    }

    @Transactional
    public void unlikePost(Long postLikeId){

        postLikeRepository.deleteById(postLikeId);
    }

    @Transactional
    public LikeCreateResponse likeComment(Long commentId, LikeCreateRequest likeCreateRequest){

        Member member = memberRepository.findById(likeCreateRequest.getMemberId())
                .orElseThrow();
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow();

        CommentLike commentLike = commentLikeRepository.save(CommentLike.of(member, comment));
        return new LikeCreateResponse(commentLike.getId());
    }

    @Transactional
    public void unlikeComment(Long commentLikeId){

        commentLikeRepository.deleteById(commentLikeId);
    }

    @Transactional
    public LikeCreateResponse likeRecomment(Long recommentId, LikeCreateRequest likeCreateRequest){

        Member member = memberRepository.findById(likeCreateRequest.getMemberId())
                .orElseThrow();
        Recomment recomment = recommentRepository.findById(recommentId)
                .orElseThrow();

        RecommentLike recommentLike = recommentLikeRepository.save(RecommentLike.of(member, recomment));
        return new LikeCreateResponse(recommentLike.getId());
    }

    @Transactional
    public void unlikeRecomment(Long recommentLikeId){

        recommentLikeRepository.deleteById(recommentLikeId);
    }
}
