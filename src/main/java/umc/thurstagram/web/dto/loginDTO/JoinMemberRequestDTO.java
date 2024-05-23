package umc.thurstagram.web.dto.loginDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class JoinMemberRequestDTO {
    @NotBlank(message = "nickname is mandatory")
    private String nickname;
    @NotBlank(message = "Password is mandatory")
    private String password;
    @NotBlank(message = "name is mandatory")
    private String name;
}
