package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.domain.Follow;
import umc.thurstagram.domain.Member;
import umc.thurstagram.dto.ViewFollowResponseDto;
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
}
