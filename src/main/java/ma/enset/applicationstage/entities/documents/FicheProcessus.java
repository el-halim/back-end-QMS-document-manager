package ma.enset.applicationstage.entities.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.applicationstage.entities.Ressource;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FicheProcessus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false ,updatable = false)
    private Long id;
    private String nameDocument;
    private String filenameUrl;
    private String description;

    @ManyToOne
    private Ressource ressource;
}
