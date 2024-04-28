package umc.thurstagram.web.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umc.thurstagram.web.dto.post.PostResponseDTO;

@RestController
@RequestMapping("/p")
@RequiredArgsConstructor
public class PostController {


    @GetMapping("/{postId}")
    public ResponseEntity<PostResponseDTO.PostDetailDTO> getDetailPost(@PathVariable(value = "postId") Long postId) {

        return
    }
    @GetMapping("/{postId}/likes")
    public ResponseEntity<PostResponseDTO.PostLikeDTO> getLikes(@PathVariable(value = "postId") Long postId){
        return
    }

    @PostMapping("")
    public ResponseEntity<> postFeed()
}
