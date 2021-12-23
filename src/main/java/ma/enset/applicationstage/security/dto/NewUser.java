package ma.enset.applicationstage.security.dto;

import lombok.Data;
import ma.enset.applicationstage.entities.Processus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
@Data
public class NewUser {

    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    private String username;
    @NotBlank
    private Processus processus;
    @NotBlank
    private String password;
    @Email
    private String email;

    private String roles ;

}
