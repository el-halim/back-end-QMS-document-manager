package ma.enset.applicationstage.dao;

import ma.enset.applicationstage.entities.Processus;
import ma.enset.applicationstage.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserById(Long id);

    Optional<User> findByUsername(String username);
    List<User> findAllByProcessusId(Long id);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

}
