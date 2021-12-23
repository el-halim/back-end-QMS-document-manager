package ma.enset.applicationstage.security.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.enset.applicationstage.entities.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@NoArgsConstructor @AllArgsConstructor @Data
public class JwtDto {
    private String token;
    private String bearer = "Bearer";
    private String username;
    private User user;
    private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token) {
        this.token = token;
    }

    public JwtDto(String token, String username, Collection<? extends GrantedAuthority> authorities,User user) {
        this.token = token;
        this.username = username;
        this.authorities = authorities;
        this.user=user;
    }

}
