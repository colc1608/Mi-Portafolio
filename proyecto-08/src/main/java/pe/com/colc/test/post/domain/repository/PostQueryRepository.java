package pe.com.colc.test.post.domain.repository;

import pe.com.colc.test.post.domain.model.PostQuery;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PostQueryRepository {

    Optional<PostQuery> findById(int id);
    List<PostQuery> searchBy(Map<String, String> params);
    List<PostQuery> findAllPosts();

}
