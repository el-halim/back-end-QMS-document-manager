package ma.enset.applicationstage.web;


import ma.enset.applicationstage.entities.Service;
import ma.enset.applicationstage.service.ProcessusInitService;
import ma.enset.applicationstage.service.ServiceInitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/service")
public class ControllerService {
    private final ServiceInitService serviceInitService;
    private final ProcessusInitService processusInitService;

    public ControllerService(ServiceInitService serviceInitService, ProcessusInitService processusInitService){
        this.serviceInitService=serviceInitService;
        this.processusInitService = processusInitService;
    }
    @CrossOrigin("*")
    @GetMapping("/all")

    public ResponseEntity<List<Service>> getAllServices(){
        List<Service> services =  serviceInitService.findAllService();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }
    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Service> addProcessus(@RequestBody Service service){
        Service newService =serviceInitService.addService(service);
        return new ResponseEntity<>(service, HttpStatus.CREATED);
    }


    @CrossOrigin("*")
    @PutMapping("/update")
    public ResponseEntity<Service> updateUser(@RequestBody Service service){
        System.out.println(service.getProcessusList());
        Service updateService =serviceInitService.updateService(service);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @CrossOrigin("*")
    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Service> deleteService(@PathVariable("id") Long id){
        processusInitService.deleteProcessusByIdService(id);
        serviceInitService.deleteService(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
