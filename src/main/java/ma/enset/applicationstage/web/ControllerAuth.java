package ma.enset.applicationstage.web;


import ma.enset.applicationstage.dao.UserRepository;
import ma.enset.applicationstage.dto.Message;
import ma.enset.applicationstage.entities.Role;
import ma.enset.applicationstage.entities.User;
import ma.enset.applicationstage.security.dto.JwtDto;
import ma.enset.applicationstage.security.dto.LoginUser;
import ma.enset.applicationstage.security.dto.NewUser;
import ma.enset.applicationstage.security.enums.RoleName;
import ma.enset.applicationstage.security.jwt.JwtProvider;
import ma.enset.applicationstage.service.RoleService;
import ma.enset.applicationstage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class ControllerAuth {



    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserRepository userRepository;



    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult){

        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("champs mal placés"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt,userDetails.getUsername(),userDetails.getAuthorities(),userRepository.findByUsername(loginUser.getUsername()).get());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }













//    @GetMapping("/")
//    public String login(){
//        return "auth succes";
//    }


}
