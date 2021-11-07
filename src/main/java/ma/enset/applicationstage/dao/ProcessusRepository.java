package ma.enset.applicationstage.dao;

import ma.enset.applicationstage.entities.Processus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessusRepository extends JpaRepository<Processus,Long> {
    List<Processus> findAllByServiceId(Long id);

}
