package ma.enset.applicationstage.web;


import ma.enset.applicationstage.entities.Service;
import ma.enset.applicationstage.entities.User;
import ma.enset.applicationstage.service.ServiceInitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/service")
public class ControllerService {
    private final ServiceInitService serviceInitService;

    public ControllerService(ServiceInitService serviceInitService){
        this.serviceInitService=serviceInitService;
    }
    @CrossOrigin("*")
    @GetMapping("/all")
    public ResponseEntity<List<Service>> getAllServices(){
        List<Service> services =  serviceInitService.findAllService();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

}
