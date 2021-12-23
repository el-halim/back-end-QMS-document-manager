package ma.enset.applicationstage.service;

import ma.enset.applicationstage.dao.ServiceRepository;
import ma.enset.applicationstage.entities.Processus;
import ma.enset.applicationstage.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import ma.enset.applicationstage.entities.Service;


import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class ServiceInitService {

    @Autowired
    private ServiceRepository serviceRepository;

    public List<ma.enset.applicationstage.entities.Service> findAllService(){
        return serviceRepository.findAll();
    }

    public Service addService(Service service) {
        return serviceRepository.save(service);
    }

    public Service updateService(Service service) {
        return serviceRepository.save(service);
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }
}
