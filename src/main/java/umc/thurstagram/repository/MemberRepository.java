package umc.thurstagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.thurstagram.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Member getMemberByNickname(String nickName);
    boolean existsMemberByNickname(String nickname);
}
