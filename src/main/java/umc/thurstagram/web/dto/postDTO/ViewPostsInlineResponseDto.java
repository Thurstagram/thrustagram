package umc.thurstagram.web.dto.postDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewPostsInlineResponseDto {
    private Long postId;
    private String firstPic;
}
