package pe.com.colc.test.post.infraestructure.inbound.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.colc.test.post.application.find.PostFindUseCase;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostFindUseCase postFindUseCase;


    @GetMapping
    public ResponseEntity findAllPosts(){
        return ResponseEntity.ok(postFindUseCase.findAllPosts());
    }

}
