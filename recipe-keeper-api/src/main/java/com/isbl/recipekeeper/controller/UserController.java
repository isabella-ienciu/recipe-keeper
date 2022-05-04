package com.isbl.recipekeeper.controller;

import com.isbl.recipekeeper.auth.ApplicationUser;
import com.isbl.recipekeeper.auth.ApplicationUserService;
import com.isbl.recipekeeper.auth.User;
import com.isbl.recipekeeper.security.JWTTokenProvider;
import static com.isbl.recipekeeper.security.SecurityConstant.*;
import static org.springframework.http.HttpStatus.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpResponse;
import java.security.Principal;
import java.util.Base64;
import java.util.logging.Logger;

@RestController
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());
    private final ApplicationUserService userService;
    private final JWTTokenProvider jwtTokenProvider;

    public UserController(ApplicationUserService userService, JWTTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/user/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        LOGGER.info("Received authentication request.");
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        if(!userDetails.getPassword().equals(user.getPassword())){
            LOGGER.info("Authentication request failed. Invalid credentials.");
            return new ResponseEntity<>(null,null,UNAUTHORIZED);
        }
        LOGGER.info("Authentication successful. Sending jwt header.");
        HttpHeaders jwtHeader = getJwtHeader(userDetails);
        User loginUser = new User(userDetails);
        return new ResponseEntity<>(loginUser, jwtHeader, OK);
    }

    private HttpHeaders getJwtHeader(UserDetails user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

}
