package management.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@Builder
@ToString
public class JwtResponse {

    private String token;
    private final String type = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
}