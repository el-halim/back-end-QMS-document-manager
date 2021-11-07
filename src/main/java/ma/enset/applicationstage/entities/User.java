package ma.enset.applicationstage.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false ,updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String adresse;
//    Role role ;
    private String profileImageUrl;

//    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
//    private Collection<Processus> processusCollection = new ArrayList<>();




//    private String profileImageUrl;
//    private Date lastLoginDate;
//    private Date getLastLoginDateDisplay;
//    private Date joinDate;
////    private String[] roles; // ROLE_USER { read ,edit } , ROLE_ADMIN {delete}
////    private String [] authorities;
//    private boolean isActtive;
//    private boolean isNotLocked;



}
