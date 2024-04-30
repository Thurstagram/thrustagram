package umc.thurstagram.service.memberService;

import umc.thurstagram.domain.Member;

public interface MemberService {

    Member getMemberByNickname(String nickname);
}
