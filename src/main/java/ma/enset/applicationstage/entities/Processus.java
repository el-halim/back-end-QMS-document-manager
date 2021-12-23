package ma.enset.applicationstage.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

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


//    @OneToMany(mappedBy = "processus")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Collection<User> userList;
//    @ManyToMany(fetch = FetchType.EAGER)
//    private Collection <User> users = new ArrayList<>();
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Service service;
//    @ManyToOne
//    private Categorie categorie;
//    @OneToOne
//    private Ressource ressource;

}
