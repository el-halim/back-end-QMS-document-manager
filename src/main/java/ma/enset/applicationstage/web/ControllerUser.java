package ma.enset.applicationstage.web;


import ma.enset.applicationstage.dto.Message;
import ma.enset.applicationstage.entities.Role;
import ma.enset.applicationstage.entities.User;
import ma.enset.applicationstage.security.dto.NewUser;
import ma.enset.applicationstage.security.enums.RoleName;
import ma.enset.applicationstage.service.RoleService;
import ma.enset.applicationstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class ControllerUser {
    private final UserService userInitService;
    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleService roleService;

    public ControllerUser(UserService userService) {
        this.userInitService = userService;
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userInitService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }




    @CrossOrigin("*")
    @PostMapping("/new")
    public ResponseEntity<?> Nouveau(@Valid @RequestBody NewUser newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("champs incorrects ou e-mail invalide"), HttpStatus.BAD_REQUEST);
        if(userService.existeByUsername(newUser.getUsername()))
            return new ResponseEntity(new Message("ce nom d'utilisateur existe déjà"), HttpStatus.BAD_REQUEST);
        if(userService.existeByEmail(newUser.getEmail()))
            return new ResponseEntity(new Message("email existe déjà"), HttpStatus.BAD_REQUEST);
        User user =
                new User(newUser.getFirstname(),newUser.getLastname(), newUser.getUsername(), newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));

        Set<Role> roles = new HashSet<>();
        //roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());

        System.out.println("*****************************************************");
        System.out.println(newUser.getRoles());
        if(newUser.getRoles().contains("admin")) {
            roles.add(roleService.getByRoleName(RoleName.ROLE_ADMIN).get());
//            user.setRole("ROLE_ADMIN");
        }
        if(newUser.getRoles().contains("user"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_USER).get());
        if(newUser.getRoles().contains("pilote"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_PILOTE).get());
        if(newUser.getRoles().contains("QC"))
            roles.add(roleService.getByRoleName(RoleName.ROLE_QC).get());
        user.setRoles(roles);
        userService.addUser(user);
        return new ResponseEntity(new Message("utilisateur enregistré"), HttpStatus.CREATED);
    }




    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser =userInitService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin("*")
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser =userInitService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin("*")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        userInitService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
