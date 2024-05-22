package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.apipayload.Handler.CommentHandler;
import umc.thurstagram.apipayload.Handler.PostHandler;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.converter.CommentConverter;
import umc.thurstagram.domain.Comment;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.Recomment;
import umc.thurstagram.exception.GeneralException;
import umc.thurstagram.web.dto.request.CommentCreateRequest;
import umc.thurstagram.web.dto.response.CommentCreateResponse;
import umc.thurstagram.repository.CommentRepository;
import umc.thurstagram.repository.MemberRepository;
import umc.thurstagram.repository.PostRepository;
import umc.thurstagram.repository.RecommentRepository;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final RecommentRepository recommentRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    @Transactional
    public CommentCreateResponse writeComment(Long postId, CommentCreateRequest commentCreateRequest){

        Member member = memberRepository.findById(commentCreateRequest.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostHandler(ErrorStatus.POST_NOT_FOUND));

        Comment comment = commentRepository.save(CommentConverter.toComment(member, post, commentCreateRequest));
        return new CommentCreateResponse(comment.getPost().getUpdated_at());
    }

    @Transactional
    public void deleteByCommentId(Long commentId){

        commentRepository.deleteById(commentId);
    }

    @Transactional
    public CommentCreateResponse writeRecomment(Long commentId, CommentCreateRequest commentCreateRequest){

        Member member = memberRepository.findById(commentCreateRequest.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new CommentHandler(ErrorStatus.COMMENT_NOT_FOUND));

        Recomment recomment = recommentRepository.save(CommentConverter.toRecomment(member, comment, commentCreateRequest));
        return new CommentCreateResponse(recomment.getComment().getUpdated_at());
    }

    @Transactional
    public void deleteByRecommentId(Long recommentId){

        recommentRepository.deleteById(recommentId);
    }
}
