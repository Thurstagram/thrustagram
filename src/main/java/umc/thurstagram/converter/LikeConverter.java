package umc.thurstagram.converter;

import umc.thurstagram.domain.*;
import umc.thurstagram.web.dto.response.LikeCreateResponse;

public class LikeConverter {

    public static PostLike toPostLike(Member member, Post post){
        return PostLike.builder()
                .member(member)
                .post(post)
                .build();
    }

    public static CommentLike toCommentLike(Member member, Comment comment){
        return CommentLike.builder()
                .member(member)
                .comment(comment)
                .build();
    }

    public static RecommentLike toRecommentLike(Member member, Recomment recomment){
        return RecommentLike.builder()
                .member(member)
                .recomment(recomment)
                .build();
    }
}
