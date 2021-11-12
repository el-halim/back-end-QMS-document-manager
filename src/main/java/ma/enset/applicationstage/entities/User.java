package ma.enset.applicationstage.entities;

import com.sun.org.apache.xpath.internal.operations.String;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Resource;
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
   // private String userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    private String phone;
    private String adresse;
//    Role role ;
    private String profileImageUrl;

//    private String[] roles; // ROLE_USER { read ,edit } , ROLE_ADMIN {delete}
//    private String[] authorities;

//    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
//    private Collection<Processus> processusCollection = new ArrayList<>();




//    private String profileImageUrl;
//    private Date lastLoginDate;
//    private Date getLastLoginDateDisplay;
//    private Date joinDate;
//
//    private boolean isActtive;
//    private boolean isNotLocked;



}
