package umc.thurstagram.service.commentService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.domain.Comment;
import umc.thurstagram.repository.CommentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public List<Comment> getComments(Long postId){
        return commentRepository.findCommentsByPostId(postId);
    }
}
