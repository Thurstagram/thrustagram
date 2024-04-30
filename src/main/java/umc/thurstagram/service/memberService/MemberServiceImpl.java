package umc.thurstagram.service.memberService;


import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.domain.Member;
import umc.thurstagram.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Member getMemberByNickname(String nickname) {
        return memberRepository.getMemberByNickname(nickname);
    }
}
