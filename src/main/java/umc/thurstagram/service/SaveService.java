package umc.thurstagram.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.thurstagram.apipayload.Handler.TempHandler;
import umc.thurstagram.apipayload.code.status.ErrorStatus;
import umc.thurstagram.converter.SaveConverter;
import umc.thurstagram.domain.Member;
import umc.thurstagram.domain.Post;
import umc.thurstagram.domain.PostImage;
import umc.thurstagram.domain.Save;
import umc.thurstagram.exception.GeneralException;
import umc.thurstagram.web.dto.request.SaveCreateRequest;
import umc.thurstagram.web.dto.response.SaveCreateResponse;
import umc.thurstagram.web.dto.response.SaveListResponse;
import umc.thurstagram.web.dto.response.SaveResponse;
import umc.thurstagram.repository.MemberRepository;
import umc.thurstagram.repository.PostImageRepository;
import umc.thurstagram.repository.PostRepository;
import umc.thurstagram.repository.SaveRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaveService {

    private final SaveRepository saveRepository;
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final PostImageRepository postImageRepository;

    @Transactional
    public SaveCreateResponse savePost(SaveCreateRequest saveCreateRequest){

        Member member = memberRepository.findById(saveCreateRequest.getMemberId())
                .orElseThrow(() -> new GeneralException(ErrorStatus.SESSION_UNAUTHORIZED));
        Post post = postRepository.findById(saveCreateRequest.getPostId())
                .orElseThrow(() -> new TempHandler(ErrorStatus.POST_NOT_FOUND));

        Save save = Save.builder()
                .member(member)
                .post(post)
                .build();

        saveRepository.save(save);
        SaveCreateResponse saveCreateResponse = SaveConverter.toSaveCreateResponse(save);
        return saveCreateResponse;
    }

    public SaveListResponse getAllByMemberId(Long memberId){
        
        List<Save> saves = saveRepository.findAllByMember_Id(memberId);
        List<SaveResponse> saveResponses = new ArrayList<>();

        for (Save save : saves) {
            PostImage postImage = postImageRepository.findFirstByPost_Id(save.getPost().getId());

            SaveResponse saveResponse = SaveResponse.builder()
                    .saveId(save.getId())
                    .postId(save.getPost().getId())
                    .imageUrl(postImage.getImgUrl())
                    .build();

            saveResponses.add(saveResponse);
        }

        return new SaveListResponse(saveResponses);
    }

    @Transactional
    public void deleteBySaveId(Long saveId){

        saveRepository.deleteById(saveId);
    }
}
