package umc.thurstagram.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.service.joinService.JoinService;
import umc.thurstagram.web.dto.JoinMemberRequestDTO;


@RestController
@RequiredArgsConstructor
public class JoinController {
    private final JoinService joinService;

    @PostMapping("/join")
    public ApiResponse<?> join(@RequestBody @Valid JoinMemberRequestDTO joinMemberRequestDTO) {
        joinService.joinProcess(joinMemberRequestDTO);

        return ApiResponse.onSuccess(null);
    }

}
