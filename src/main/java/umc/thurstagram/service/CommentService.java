package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.domain.Comment;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.Recomment;
import umc.thurstagram.web.dto.commentDTO.CommentCreateRequest;
import umc.thurstagram.web.dto.commentDTO.CommentCreateResponse;
import umc.thurstagram.repository.CommentRepository;
import umc.thurstagram.repository.MemberRepository;
import umc.thurstagram.repository.PostRepository;
import umc.thurstagram.repository.RecommentRepository;

@Slf4j
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
                .orElseThrow();
        Post post = postRepository.findById(postId)
                .orElseThrow();

        Comment comment = commentRepository.save(Comment.of(member, post, commentCreateRequest));
        return new CommentCreateResponse(comment.getId());
    }

    @Transactional
    public void deleteByCommentId(Long commentId){

        commentRepository.deleteById(commentId);
    }

    @Transactional
    public CommentCreateResponse writeRecomment(Long commentId, CommentCreateRequest commentCreateRequest){

        Member member = memberRepository.findById(commentCreateRequest.getMemberId())
                .orElseThrow();
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow();

        Recomment recomment = recommentRepository.save(Recomment.of(member, comment, commentCreateRequest));
        return new CommentCreateResponse(recomment.getId());
    }

    @Transactional
    public void deleteByRecommentId(Long recommentId){

        recommentRepository.deleteById(recommentId);
    }
}
