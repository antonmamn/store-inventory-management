package management.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@ConfigurationProperties(prefix = "rsa")
public class RsaKeyProperties {

    RSAPublicKey publicKey;

    RSAPrivateKey privateKey;

}