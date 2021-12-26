package ma.enset.applicationstage.dao;

import ma.enset.applicationstage.entities.Files;
import ma.enset.applicationstage.security.enums.TypeDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<Files, String> {

     List<Files> findAllByTypeDoc(TypeDoc type_doc);

     List<Files> findAllByTypeDocAndProcessusIdEquals(TypeDoc typeDoc,Long id);

}
