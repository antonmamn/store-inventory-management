package management.security.service;

import management.security.User;
import management.security.model.UserRegisterForm;

public interface UserService {
    User saveNewUser(UserRegisterForm userRegisterForm);
}
