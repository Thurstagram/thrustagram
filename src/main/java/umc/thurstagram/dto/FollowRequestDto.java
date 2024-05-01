package umc.thurstagram.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.thurstagram.domain.Follow;

@Getter
@NoArgsConstructor
public class FollowRequestDto {
    private Long followerId;
    private Long acceptorId;

    @Builder
    public FollowRequestDto(Follow follow) {
        this.followerId = follow.getFollower().getId();
        this.acceptorId = follow.getAcceptor().getId();
    }
}
