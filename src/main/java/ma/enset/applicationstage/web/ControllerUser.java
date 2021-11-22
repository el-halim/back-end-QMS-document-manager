package ma.enset.applicationstage.web;


import ma.enset.applicationstage.entities.User;
import ma.enset.applicationstage.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class ControllerUser {
    private final UserService userInitService;


    public ControllerUser(UserService userService) {
        this.userInitService = userService;
    }

    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userInitService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser =userInitService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @CrossOrigin("*")
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User User){
        User updateUser =userInitService.updateUser(User);
        return new ResponseEntity<>(User, HttpStatus.OK);
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
