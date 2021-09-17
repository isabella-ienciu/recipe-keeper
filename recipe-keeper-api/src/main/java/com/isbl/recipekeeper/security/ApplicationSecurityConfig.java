package com.isbl.recipekeeper.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.isbl.recipekeeper.security.ApplicationUserRole.ADMIN;
import static com.isbl.recipekeeper.security.ApplicationUserRole.USER;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails isabellaUser = User.builder()
                .username("isabella")
                .password(passwordEncoder.encode("password"))
                .roles(ADMIN.name()) //ROLE_ADMIN
                .build();
        UserDetails userUser = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .roles(USER.name()) //ROLE_USER
                .build();
        return new InMemoryUserDetailsManager(isabellaUser, userUser);
    }
}
