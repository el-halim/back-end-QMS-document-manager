package ma.enset.applicationstage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.applicationstage.entities.documents.FicheProcessus;

import javax.persistence.*;
import javax.swing.text.Document;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false ,updatable = false)
    private Long id;
    /**
     *  Documents
     * */


    @OneToMany(mappedBy = "ressource")
    private Collection<FicheProcessus> filesFicheProcessus;


//    @OneToOne (mappedBy = "ressource")
//    private Processus processus;



}
