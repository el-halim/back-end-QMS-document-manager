package ma.enset.applicationstage.security.jwt;

import io.jsonwebtoken.*;
import ma.enset.applicationstage.entities.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import sun.text.normalizer.ICUBinary;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtProvider {

    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
     //   List<String> roles = userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder().setSubject(userPrincipal.getUsername())
                //.claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getUsernameFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {

            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;


        } catch (MalformedJwtException e) {
            logger.error("token mal formee");
        }catch (UnsupportedJwtException e) {
            logger.error("token not suported");
        }catch (ExpiredJwtException e) {
            logger.error("token expiree");
        }catch (IllegalArgumentException e) {
            logger.error("token vide");
        }catch (SignatureException e) {
            logger.error("echouer dans la signature");
        }
        return false;
    }

}
