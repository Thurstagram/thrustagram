package umc.thurstagram.converter;

import umc.thurstagram.domain.Follow;
import umc.thurstagram.web.dto.FollowResponseDto;

public class FollowConverter {

    public static FollowResponseDto toFollowResponse(Follow follow) {
        return FollowResponseDto.builder()
                .updatedAt(follow.getFollower().getUpdated_at())
                .build();
    }
}
