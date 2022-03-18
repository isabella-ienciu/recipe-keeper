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

@RestController
public class UserController {

    private ApplicationUserService userService;
    private JWTTokenProvider jwtTokenProvider;

    public UserController(ApplicationUserService userService, JWTTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
        //this.authenticationManager = authenticationManager;
    }

    @PostMapping("/user/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        //authenticate(user.getUsername(), user.getPassword());
        UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        if(!userDetails.getPassword().equals(user.getPassword())){
            return new ResponseEntity<>(null,null,UNAUTHORIZED);
        }
        HttpHeaders jwtHeader = getJwtHeader(userDetails);
        User loginUser = new User(userDetails);
        return new ResponseEntity<>(loginUser, jwtHeader, OK);
    }

    private HttpHeaders getJwtHeader(UserDetails user) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(JWT_TOKEN_HEADER, jwtTokenProvider.generateJwtToken(user));
        return headers;
    }

/*    private void authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    }*/

}
