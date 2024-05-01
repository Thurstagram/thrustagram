package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.domain.Follow;
import umc.thurstagram.domain.Member;
import umc.thurstagram.dto.FollowRequestDto;
import umc.thurstagram.dto.ViewFollowResponseDto;
import umc.thurstagram.exception.GeneralException;
import umc.thurstagram.repository.FollowRepository;
import umc.thurstagram.repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowService {
    private final FollowRepository followRepository;
    private final  MemberRepository memberRepository;

    @Transactional
    public List<ViewFollowResponseDto> viewFollowers(Long memberId) {
        List<Follow> follows = followRepository.findAllByAcceptor_Id(memberId);
        List<ViewFollowResponseDto> viewFollowResponseDtos = new ArrayList<>();
        for(Follow follow : follows) {
            Member member = follow.getFollower();
            ViewFollowResponseDto viewFollowResponseDto = ViewFollowResponseDto.builder()
                    .memberId(member.getId())
                    .name(member.getName())
                    .nickname(member.getNickname())
                    .profileImg(member.getProfile_img())
                    .build();
            viewFollowResponseDtos.add(viewFollowResponseDto);
        }
        return viewFollowResponseDtos;
    }

    @Transactional
    public List<ViewFollowResponseDto> viewFollowings(Long memberId) {
        List<Follow> follows = followRepository.findAllByFollower_Id(memberId);
        List<ViewFollowResponseDto> viewFollowResponseDtos = new ArrayList<>();
        for(Follow follow : follows) {
            Member member = follow.getAcceptor();
            ViewFollowResponseDto viewFollowResponseDto = ViewFollowResponseDto.builder()
                    .memberId(member.getId())
                    .name(member.getName())
                    .nickname(member.getNickname())
                    .profileImg(member.getProfile_img())
                    .build();
            viewFollowResponseDtos.add(viewFollowResponseDto);
        }
        return viewFollowResponseDtos;
    }

    @Transactional
    public Follow follow(FollowRequestDto followRequestDto) {
        Member follower = memberRepository.findById(followRequestDto.getFollowerId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Member acceptor = memberRepository.findById(followRequestDto.getAcceptorId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Follow f = Follow.builder()
                .follower(follower)
                .acceptor(acceptor)
                .build();
        followRepository.save(f);
        return f;
    }

    @Transactional
    public void followCancel(FollowRequestDto followRequestDto) {
        Member follower = memberRepository.findById(followRequestDto.getFollowerId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Member acceptor = memberRepository.findById(followRequestDto.getAcceptorId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Follow f = followRepository.findByFollowerAndAcceptor(follower,acceptor);
        followRepository.delete(f);
    }
}
