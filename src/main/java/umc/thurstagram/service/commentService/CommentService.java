package umc.thurstagram.service.commentService;

import umc.thurstagram.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments(Long postId);
}
