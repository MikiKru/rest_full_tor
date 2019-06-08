package pl.sda.restfull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.restfull.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
