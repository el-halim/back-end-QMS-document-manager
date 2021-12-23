package ma.enset.applicationstage.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",joinColumns = @JoinColumn(name = "user_id")
    ,inverseJoinColumns = @JoinColumn (name = "role_id"))
    private Set<Role> roles =new HashSet<>();

//    @ManyToOne
//    private Processus processus;

   // private String role;
    private String phone;
    private String adresse;
    private String profileImageUrl;

//    public User(String firstName,String lastName, String username, String email, String password, Processus processus) {
//        this.processus=processus;
//        this.firstName =firstName;
//        this.lastName =lastName;
//        this.username=username;
//        this.email=email;
//        this.password=password;
//    }

    public User(String firstName, String lastName, String username, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //    public User(Long id, String username, String password) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//    }

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
