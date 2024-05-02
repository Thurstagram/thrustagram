package umc.thurstagram.converter;

import umc.thurstagram.domain.Hashtag;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.PostHashtag;

public class PostHashtagConverter {

    public static PostHashtag toPostHashtag(Post post, Hashtag hashtag) {
        return PostHashtag.builder()
                .post(post)
                .hashtag(hashtag)
                .build();
    }
}
