package management.security.controller;

import management.security.TokenService;
import management.security.User;
import management.security.UserRepositoryJPA;
import management.security.model.JwtResponse;
import management.security.model.LoginRequest;
import management.security.model.UserRegisterForm;
import management.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    private final PasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public AuthController(TokenService tokenService, AuthenticationManager authenticationManager, UserService userService, UserRepositoryJPA userRepositoryJPA, PasswordEncoder bCryptPasswordEncoder) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {

        return ResponseEntity.ok("Success");
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest userLogin, HttpServletResponse response) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUserName(), userLogin.getPassword()));

        String token = tokenService.generateToken(authentication);

        User securityUser = (User) authentication.getPrincipal();

        JwtResponse jwtResponse = JwtResponse.builder()
                .token(token)
                .username(securityUser.getUsername())
                .authorities(securityUser.getAuthorities())
                .build();
        response.setHeader("Set-Cookie", "promo_shown=1; SameSite=Strict");
        return ResponseEntity.ok(jwtResponse);
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterForm userRegisterForm){


        return ResponseEntity.ok(userService.saveNewUser(userRegisterForm));

    }
}