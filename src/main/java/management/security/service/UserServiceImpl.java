package management.security.service;

import management.security.User;
import management.security.UserRepositoryJPA;
import management.security.model.UserRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepositoryJPA userRepositoryJPA;


    private final PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserRepositoryJPA userRepositoryJPA, PasswordEncoder bCryptPasswordEncoder) {
        this.userRepositoryJPA = userRepositoryJPA;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User saveNewUser(UserRegisterForm userRegisterForm) {
        User user = User.builder()
                .userName(userRegisterForm.getUserName())
                .firstName(userRegisterForm.getFirstName())
                .lastName(userRegisterForm.getLastName())
                .password(bCryptPasswordEncoder.encode(userRegisterForm.getPassword()))
                .createDate(LocalDateTime.now())
                .deleted(false)
                .build();


        return userRepositoryJPA.save(user);
    }
}
