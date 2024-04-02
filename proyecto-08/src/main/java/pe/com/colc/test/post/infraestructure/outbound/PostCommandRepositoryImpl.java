package pe.com.colc.test.post.infraestructure.outbound;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pe.com.colc.test.post.domain.model.PostCommand;
import pe.com.colc.test.post.domain.model.PostQuery;
import pe.com.colc.test.post.domain.repository.PostCommandRepository;
import pe.com.colc.test.post.infraestructure.outbound.external.JsonPlaceholderAPIClient;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostCommandRepositoryImpl implements PostCommandRepository {

    //private final JsonPlaceholderAPIClient jsonPlaceholderAPIClient;

    @Override
    public Optional<PostQuery> createPost(PostCommand postCommand) {
        //return Optional.ofNullable(jsonPlaceholderAPIClient.create(postCommand));
        return  null;
    }

    @Override
    public Optional<PostQuery> updatePost(PostCommand postCommand) {
        //return Optional.empty();
        return null;
    }

    @Override
    public void deletePost(int id) {
        //codigo a implementar
    }
}
