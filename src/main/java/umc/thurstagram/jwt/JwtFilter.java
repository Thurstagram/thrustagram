package umc.thurstagram.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import umc.thurstagram.domain.Member;
import umc.thurstagram.web.dto.LoginUserDetailsDTO;

import java.io.IOException;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization"); // jwt token이 들어있는 헤더를 가져온다.

        if (authorization == null || !authorization.startsWith("Bearer ")) { // jwt token이 없거나 잘못된 경우
            System.out.println("token null");
            filterChain.doFilter(request, response);
            return ;
        }

        String token = authorization.split(" ")[1]; // 순수 토큰만 가져온다.

        if (jwtUtil.isExpired(token)) { // token의 유효기간을 확인한다.
            System.out.println("token expired");
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);
        LoginUserDetailsDTO loginUserDetailsDTO = new LoginUserDetailsDTO(Member.builder()
                .password("temppassword") // DB에 쿼리를 날려서 비밀번호를 가져오는 대신 임시 비멀번호를 저장해준다.
                .nickname(username)
                .role(role)
                .build()
        );
        // loginUserDetialsDTO로 생성한 token으로 세션을 생성한다.
        Authentication authToken = new UsernamePasswordAuthenticationToken(loginUserDetailsDTO, null, loginUserDetailsDTO.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }
}
