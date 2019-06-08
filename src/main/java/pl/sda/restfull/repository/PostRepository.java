package pl.sda.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.restfull.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    // SELECT * FROM post WHERE title = ?;
    Post findFirstByTitle(String title);
}
