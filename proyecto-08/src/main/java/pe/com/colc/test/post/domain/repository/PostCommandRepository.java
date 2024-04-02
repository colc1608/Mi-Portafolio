package pe.com.colc.test.post.domain.repository;

import pe.com.colc.test.post.domain.model.PostCommand;
import pe.com.colc.test.post.domain.model.PostQuery;
import java.util.Optional;

public interface PostCommandRepository {

    Optional<PostQuery> createPost(PostCommand postCommand);
    Optional<PostQuery> updatePost(PostCommand postCommand);
    void deletePost(int id);

}
