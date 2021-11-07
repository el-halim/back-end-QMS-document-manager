package ma.enset.applicationstage.service;


import ma.enset.applicationstage.dao.ProcessusRepository;
import ma.enset.applicationstage.entities.Processus;
import ma.enset.applicationstage.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProcessusInitService {

    @Autowired
    private ProcessusRepository processusRepository;

    public List<Processus> findProcessusByServiceId(Long id){
        return processusRepository.findAllByServiceId(id);
    }


    public Processus addProcessus(Processus processus) {
        return processusRepository.save(processus);
    }
}
