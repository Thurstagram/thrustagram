package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.converter.MemberConverter;
import umc.thurstagram.domain.Member;
import umc.thurstagram.dto.UpdateProfileRequestDto;
import umc.thurstagram.exception.GeneralException;
import umc.thurstagram.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member updateProfile(UpdateProfileRequestDto updateProfileRequestDto) {
        Member member = memberRepository.findById(updateProfileRequestDto.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        member.update(updateProfileRequestDto.getProfileImg(), updateProfileRequestDto.getName(), updateProfileRequestDto.getNickname());
        return member;
    }

    @Transactional
    public Member viewUserInfo(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        return member;
    }
}
