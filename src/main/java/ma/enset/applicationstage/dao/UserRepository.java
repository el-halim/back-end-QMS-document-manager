package ma.enset.applicationstage.dao;

import ma.enset.applicationstage.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteUserById(Long id);

}
