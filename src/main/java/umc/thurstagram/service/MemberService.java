package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.domain.Member;
import umc.thurstagram.web.dto.profileDTO.UpdateProfileRequestDto;
import umc.thurstagram.web.dto.profileDTO.ViewUserNumInfoResponseDto;
import umc.thurstagram.exception.GeneralException;
import umc.thurstagram.repository.FollowRepository;
import umc.thurstagram.repository.MemberRepository;
import umc.thurstagram.repository.PostRepository;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final FollowRepository followRepository;

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

    @Transactional
    public ViewUserNumInfoResponseDto viewUserNumInfo(Long memberId) {
        Long postNum = postRepository.countByMember_Id(memberId);
        Long followerNum = followRepository.countByAcceptor_Id(memberId);
        Long followingNum = followRepository.countByFollower_Id(memberId);
        ViewUserNumInfoResponseDto viewUserNumInfoResponseDto = ViewUserNumInfoResponseDto.builder()
                .postNum(postNum)
                .followerNum(followerNum)
                .followingNum(followingNum)
                .build();
        return viewUserNumInfoResponseDto;
    }
}


