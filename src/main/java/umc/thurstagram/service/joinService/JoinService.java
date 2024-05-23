package umc.thurstagram.service.joinService;

import umc.thurstagram.web.dto.loginDTO.JoinMemberRequestDTO;

public interface JoinService {
    public void joinProcess(JoinMemberRequestDTO joinMemberRequestDTO);
}
