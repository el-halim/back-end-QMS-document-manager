package ma.enset.applicationstage.dao;

import ma.enset.applicationstage.entities.Role;
import ma.enset.applicationstage.security.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleName(RoleName roleName);

}
