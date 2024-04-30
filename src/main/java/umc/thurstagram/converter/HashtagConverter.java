package umc.thurstagram.converter;

import umc.thurstagram.domain.Hashtag;
import umc.thurstagram.web.dto.post.PostRequestDTO;

public class HashtagConverter {

    public static Hashtag toHashtag(PostRequestDTO.PostFeedDTO postFeedDTO){

        return Hashtag.builder()
                .name(postFeedDTO.getPostHashTag())
                .build();
    }

}
