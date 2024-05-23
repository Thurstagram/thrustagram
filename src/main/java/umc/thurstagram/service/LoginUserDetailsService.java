package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umc.thurstagram.repository.MemberRepository;
import umc.thurstagram.web.dto.loginDTO.LoginUserDetailsDTO;

@Service
@RequiredArgsConstructor
public class LoginUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override // member를 UserDetails에 담아서 AuthenticationManager에게 보낸다.
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findMemberByNickname(username)
                .map(LoginUserDetailsDTO::new)
                .orElse(null); // 나중에 에러 처리 해주는게 좋을듯.
    }
}
