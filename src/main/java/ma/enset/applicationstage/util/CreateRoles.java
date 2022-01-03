package ma.enset.applicationstage.util;


import ma.enset.applicationstage.entities.Role;
import ma.enset.applicationstage.security.enums.RoleName;
import ma.enset.applicationstage.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateRoles implements CommandLineRunner {

    @Autowired
    RoleService rolService;

    @Override
    public void run(String... args) throws Exception {
//        Role rolAdmin = new Role(RoleName.ROLE_ADMIN);
//        Role rolPilote = new Role(RoleName.ROLE_PILOTE);
//        Role rolUser = new Role(RoleName.ROLE_USER);
////        Role rolQC = new Role(RoleName.ROLE_QC);
//        rolService.save(rolAdmin);
//        rolService.save(rolUser);
//  //      rolService.save(rolQC);
//        rolService.save(rolPilote);



    }
}
