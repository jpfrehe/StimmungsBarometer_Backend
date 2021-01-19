package de.fiduciagad.backend.user;

import de.fiduciagad.backend.group.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserByUserKennung(String name);
}
