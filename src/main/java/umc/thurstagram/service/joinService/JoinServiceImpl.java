package umc.thurstagram.service.joinService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.apipayload.Handler.TempHandler;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.domain.Member;
import umc.thurstagram.repository.MemberRepository;
import umc.thurstagram.web.dto.loginDTO.JoinMemberRequestDTO;

@Service
@RequiredArgsConstructor
public class JoinServiceImpl implements JoinService {
    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void joinProcess(JoinMemberRequestDTO joinMemberRequestDTO) {
        if (memberRepository.existsMemberByNickname(joinMemberRequestDTO.getNickname()))
            throw new TempHandler(ErrorStatus.JOIN_ALREADY_EXISTS);

        memberRepository.save(Member.builder()
                .nickname(joinMemberRequestDTO.getNickname())
                .password(bCryptPasswordEncoder.encode(joinMemberRequestDTO.getPassword()))
                .name(joinMemberRequestDTO.getName())
                .role("ROLE_ADMIN")
                .build()
        );
    }



}
