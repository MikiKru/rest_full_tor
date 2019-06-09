package pl.sda.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.restfull.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}
