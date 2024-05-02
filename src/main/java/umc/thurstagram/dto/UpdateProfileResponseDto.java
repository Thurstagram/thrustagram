package umc.thurstagram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProfileResponseDto {
    private Long memberId;
    private LocalDateTime updatedAt;
}
