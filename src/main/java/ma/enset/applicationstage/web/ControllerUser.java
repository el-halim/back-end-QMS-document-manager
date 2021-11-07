package ma.enset.applicationstage.web;


import ma.enset.applicationstage.dao.UserRepository;
import ma.enset.applicationstage.entities.User;
import ma.enset.applicationstage.service.UserInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class ControllerUser {
    private final UserInitService userInitService;


    public ControllerUser(UserInitService userInitService) {
        this.userInitService = userInitService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users =  userInitService.findAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser =userInitService.addUser(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User User){
        User updateUser =userInitService.updateUser(User);
        return new ResponseEntity<>(User, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
        userInitService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}