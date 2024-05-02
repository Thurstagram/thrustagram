package umc.thurstagram.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class PostRequestDTO {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PostFeedDTO{

        String contents;
        String post_img_url;
        String postHashTag;
        LocalDateTime created_at;

    }
}
