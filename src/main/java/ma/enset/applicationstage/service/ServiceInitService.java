package ma.enset.applicationstage.service;

import ma.enset.applicationstage.dao.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceInitService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ma.enset.applicationstage.entities.Service> findAllService(){
        return serviceRepository.findAll();
    }
}
