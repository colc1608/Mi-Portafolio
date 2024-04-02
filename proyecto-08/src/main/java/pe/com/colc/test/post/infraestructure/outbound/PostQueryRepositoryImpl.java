package pe.com.colc.test.post.infraestructure.outbound;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.com.colc.test.post.domain.model.PostQuery;
import pe.com.colc.test.post.domain.repository.PostQueryRepository;
import pe.com.colc.test.post.infraestructure.outbound.external.JsonPlaceholderAPIClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostQueryRepositoryImpl implements PostQueryRepository {

    //private final JsonPlaceholderAPIClient jsonPlaceholderAPIClient;

    @Override
    public Optional<PostQuery> findById(int id) {
        //return Optional.ofNullable(jsonPlaceholderAPIClient.findPostById(id));
        return null;
    }

    @Override
    public List<PostQuery> searchBy(Map<String, String> params) {
        //return jsonPlaceholderAPIClient.searchByParam(params);
        return null;
    }

    @Override
    public List<PostQuery> findAllPosts() {
        //return jsonPlaceholderAPIClient.getAllPosts();
        return null;
    }
}
