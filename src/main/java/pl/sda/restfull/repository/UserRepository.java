package pl.sda.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.restfull.model.User;

@Repository                                        // model,typPK
public interface UserRepository extends JpaRepository<User,Long> {
}
