package ma.enset.applicationstage.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Processus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false ,updatable = false)
    private Long id;
    private String name;
    private String description;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection <User> users = new ArrayList<>();
    @ManyToOne
    private Service service;
    @ManyToOne
    private Categorie categorie;
    @OneToOne
    private Ressource ressource;

}
