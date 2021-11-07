package ma.enset.applicationstage.dao;

import ma.enset.applicationstage.entities.Processus;
import ma.enset.applicationstage.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service,Long> {

}
