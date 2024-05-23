package umc.thurstagram.web.dto.profileDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ViewUserNumInfoResponseDto {
    private Long postNum;
    private Long followerNum;
    private Long followingNum;
}
