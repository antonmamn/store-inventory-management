package management.security.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserRegisterForm {

    private String userName;
    private String firstName;
    private String lastName;

    private String password;


}