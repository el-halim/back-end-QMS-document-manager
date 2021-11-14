package ma.enset.applicationstage.service;


import ma.enset.applicationstage.dao.RoleRepository;
import ma.enset.applicationstage.entities.Role;
import ma.enset.applicationstage.security.enums.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> getByRoleName(RoleName roleName){
        return roleRepository.findByRoleName(roleName);
    }
    public void save(Role role){
        roleRepository.save(role);
    }
}
