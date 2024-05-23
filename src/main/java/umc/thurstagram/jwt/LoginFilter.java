package umc.thurstagram.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.apipayload.Handler.TempHandler;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.web.dto.LoginUserDetailsDTO;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter("nickname"); // member의 nickname을 username으로 대체
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);
        // 로그인 정보를 token으로 변환
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, null);
        // AuthenticationManger에게 로그인 정보를 전달한다.
        return authenticationManager.authenticate(authToken);
    }

    @Override // 로그인 성공시 실행되는 메소드
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        // AuthenticationManger에서 인증을 마친 유저의 정보를 Authentication 클래스에 담아서 전달받는다.
        LoginUserDetailsDTO loginUserDetailsDTO = (LoginUserDetailsDTO) authentication.getPrincipal();

        String username = loginUserDetailsDTO.getUsername();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority();
        // username, role, expire time을 payload에 담아서 token을 생성한다.
        String token = jwtUtil.createJwt(username, role, 600*600*10L);

        response.addHeader("Authorization", "Bearer " + token); // RFC 7235의 정의에 희해서 인증 헤더는 Bearer 접두사를 가져야한다.

        ApiResponse<?> apiResponse = new ApiResponse<>(true, "Login successful", "로그인 성공", null);

        // 응답을 JSON 형태로 변환합니다.
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(apiResponse);


        // 응답을 클라이언트에게 보냅니다.
        response.getWriter().write(jsonResponse);


    }

    @Override // 로그인 실패시 실행되는 메소드
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) {
        throw new TempHandler(ErrorStatus.LOGIN_UNAUTHORIZED);
    }
}
