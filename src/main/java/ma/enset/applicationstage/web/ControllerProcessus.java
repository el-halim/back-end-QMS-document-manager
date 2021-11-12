package ma.enset.applicationstage.web;


import ma.enset.applicationstage.entities.Processus;
import ma.enset.applicationstage.entities.Service;
import ma.enset.applicationstage.entities.User;
import ma.enset.applicationstage.service.ProcessusInitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/processus")
public class ControllerProcessus {

    private final ProcessusInitService processusInitService;

    public ControllerProcessus(ProcessusInitService processusInitService){
        this.processusInitService=processusInitService;
    }
    @CrossOrigin("*")
    @PostMapping("/by-service")
    public ResponseEntity<List<Processus>> getProcessusByService(@RequestBody Service service){
        List<Processus> processusList= processusInitService.findProcessusByServiceId(service.getId());
        return new ResponseEntity<>(processusList,HttpStatus.OK);
    }
    @CrossOrigin("*")
    @PostMapping("/add")
    public ResponseEntity<Processus> addProcessus(@RequestBody Processus processus){
        Processus newProcessus =processusInitService.addProcessus(processus);
        return new ResponseEntity<>(processus, HttpStatus.CREATED);
    }


}
