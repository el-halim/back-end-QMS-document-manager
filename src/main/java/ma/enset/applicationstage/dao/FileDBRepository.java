package ma.enset.applicationstage.dao;

import ma.enset.applicationstage.entities.Files;
import ma.enset.applicationstage.security.enums.TypeDoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileDBRepository extends JpaRepository<Files, String> {

     List<Files> findAllByTypeDocAndApproved(TypeDoc type_doc, boolean approved);

     List<Files> findAllByTypeDocAndProcessusIdEqualsAndApproved(TypeDoc typeDoc,Long id,boolean approved);

     @Modifying(clearAutomatically = true)
     @Query("update Files f set f.approved = true where f.id = :id")
     void onApprove(@Param("id") String id);



//     @Modifying(clearAutomatically = true)
//     @Query("UPDATE Company c SET c.address = :address WHERE c.id = :companyId")
//     int updateAddress(@Param("companyId") int companyId, @Param("address") String address);

}
