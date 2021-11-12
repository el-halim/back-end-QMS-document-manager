package ma.enset.applicationstage.web;


import ma.enset.applicationstage.entities.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin("*")
public class ControllerAuth {

    @GetMapping("/")
    public String login(){
        return "auth succes";
    }


}
