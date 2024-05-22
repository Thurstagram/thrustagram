package umc.thurstagram.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.apipayload.ApiResponse;
import umc.thurstagram.web.dto.request.SaveCreateRequest;
import umc.thurstagram.web.dto.response.SaveCreateResponse;
import umc.thurstagram.web.dto.response.SaveListResponse;
import umc.thurstagram.service.SaveService;

@RestController
@RequestMapping("/save")
@RequiredArgsConstructor
public class SaveController {

    private final SaveService saveService;

    @PostMapping
    public ApiResponse<SaveCreateResponse> savePost(@RequestBody SaveCreateRequest saveCreateRequest){
        return ApiResponse.onSuccess(saveService.savePost(saveCreateRequest));
    }

    @GetMapping("/{memberId}")
    public ApiResponse<SaveListResponse> viewAllByMemberId(@PathVariable Long memberId){
        return ApiResponse.onSuccess(saveService.getAllByMemberId(memberId));
    }

    @DeleteMapping("/{saveId}")
    public ApiResponse<?> deleteBySaveId(@PathVariable Long saveId){
        saveService.deleteBySaveId(saveId);
        return ApiResponse.onSuccess("저장 취소됨");
    }
}
