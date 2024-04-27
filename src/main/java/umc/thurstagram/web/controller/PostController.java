package umc.thurstagram.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.web.dto.peed.PostResponseDTO;

@RestController
@RequestMapping("/p")
@RequiredArgsConstructor
public class PostController {


    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDTO.PostDetailDTO> getDetailPost(@PathVariable(value = "postId") Long postId) {

        return
    }

}
