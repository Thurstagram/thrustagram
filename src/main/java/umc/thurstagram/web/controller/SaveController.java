package umc.thurstagram.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.web.dto.request.SaveCreateRequest;
import umc.thurstagram.web.dto.response.SaveCreateResponse;
import umc.thurstagram.web.dto.response.SaveListResponse;
import umc.thurstagram.service.SaveService;

@Slf4j
@RestController
@RequestMapping("/save")
@RequiredArgsConstructor
public class SaveController {

    private final SaveService saveService;

    // response 형식 전체적으로 리펙토링 필요
    @PostMapping
    public ResponseEntity<SaveCreateResponse> savePost(@RequestBody SaveCreateRequest saveCreateRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(saveService.savePost(saveCreateRequest));
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<SaveListResponse> viewAllByMemberId(@PathVariable Long memberId){
        return ResponseEntity.status(HttpStatus.OK).body(saveService.getAllByMemberId(memberId));
    }

    @DeleteMapping("/{saveId}")
    public ResponseEntity<?> deleteBySaveId(@PathVariable Long saveId){
        saveService.deleteBySaveId(saveId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
