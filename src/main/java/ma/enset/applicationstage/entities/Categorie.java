package ma.enset.applicationstage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false ,updatable = false)
    private Long id;
    private String name;

//    @OneToMany(mappedBy = "categorie")
//    private Collection<Processus> processusCollection;
}
