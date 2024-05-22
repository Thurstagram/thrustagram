package umc.thurstagram.apipayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.thurstagram.apipayload.code.BaseCode;
import umc.thurstagram.apipayload.code.ReasonDto;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseCode {

    // 에러 응답
    INTERNER_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", "서버 에러"),

    // 로그인 실패
    LOGIN_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "LOGIN FAIL", "아이디 또는 비밀번호를 확인하세요"),

    // 세션 에러
    SESSION_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "유효하지 않은 세션입니다."),

    // 피드 생성 에러
    IMG_NOT_FOUND(HttpStatus.NOT_FOUND, "POST FAIL", "선택된 이미지가 없습니다"),

    // 피드 조회 실패
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "POST FAIL", "존재하지 않는 게시글입니다"),

    // 댓글 조회 실패
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMENT FAIL", "존재하지 않는 댓글입니다");





    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .isSuccess(false)
                .httpStatus(httpStatus)
                .code(code)
                .message(message)
                .build();
    }

}