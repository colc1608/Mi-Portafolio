package pe.com.colc.test.post.infraestructure.outbound.external;

import org.springframework.web.bind.annotation.*;
import pe.com.colc.test.post.domain.model.PostCommand;
import pe.com.colc.test.post.domain.model.PostQuery;
import java.util.List;
import java.util.Map;



public interface JsonPlaceholderAPIClient {

    @PostMapping
    PostQuery create(@RequestBody PostCommand request);

    @GetMapping("/{id}")
    PostQuery findPostById(@PathVariable Integer id);

    @GetMapping
    List<PostQuery> getAllPosts();

    @GetMapping
    List<PostQuery> searchByParam(@RequestParam Map<String, String> params);

}
