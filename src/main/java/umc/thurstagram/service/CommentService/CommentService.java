package umc.thurstagram.service.CommentService;

import umc.thurstagram.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getComments(Long postId);
}
