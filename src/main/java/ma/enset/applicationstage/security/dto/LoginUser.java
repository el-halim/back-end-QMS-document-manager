package ma.enset.applicationstage.security.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginUser {
    @NotBlank
    private String usernmae;
    @NotBlank
    private String password;
}
