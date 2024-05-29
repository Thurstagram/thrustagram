package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.apipayload.Handler.TempHandler;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.converter.LikeConverter;
import umc.thurstagram.domain.*;
import umc.thurstagram.web.dto.likeDTO.LikeCreateRequest;
import umc.thurstagram.web.dto.likeDTO.LikeCreateResponse;
import umc.thurstagram.exception.GeneralException;
import umc.thurstagram.repository.*;

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
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.POST_NOT_FOUND));

        PostLike postLike = postLikeRepository.save(LikeConverter.toPostLike(member, post));
        return new LikeCreateResponse(postLike.getPost().getUpdated_at());
    }

    @Transactional
    public void unlikePost(Long postLikeId){

        postLikeRepository.deleteById(postLikeId);
    }

    @Transactional
    public LikeCreateResponse likeComment(Long commentId, LikeCreateRequest likeCreateRequest){

        Member member = memberRepository.findById(likeCreateRequest.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.COMMENT_NOT_FOUND));

        CommentLike commentLike = commentLikeRepository.save(LikeConverter.toCommentLike(member, comment));
        return new LikeCreateResponse(commentLike.getComment().getUpdated_at());
    }

    @Transactional
    public void unlikeComment(Long commentLikeId){

        commentLikeRepository.deleteById(commentLikeId);
    }

    @Transactional
    public LikeCreateResponse likeRecomment(Long recommentId, LikeCreateRequest likeCreateRequest){

        Member member = memberRepository.findById(likeCreateRequest.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Recomment recomment = recommentRepository.findById(recommentId)
                .orElseThrow(() -> new TempHandler(ErrorStatus.COMMENT_NOT_FOUND));

        RecommentLike recommentLike = recommentLikeRepository.save(LikeConverter.toRecommentLike(member, recomment));
        return new LikeCreateResponse(recommentLike.getRecomment().getUpdated_at());
    }

    @Transactional
    public void unlikeRecomment(Long recommentLikeId){

        recommentLikeRepository.deleteById(recommentLikeId);
    }
}
