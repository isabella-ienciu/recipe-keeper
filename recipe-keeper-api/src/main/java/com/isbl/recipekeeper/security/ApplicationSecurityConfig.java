package com.isbl.recipekeeper.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.isbl.recipekeeper.security.ApplicationUserPermission.*;
import static com.isbl.recipekeeper.security.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //TODO: will understand later in the tutorial
                .authorizeRequests()
                //.antMatchers("/api/**").hasRole(ADMIN.name())
                //.antMatchers("/api/v1/recipes/**", HttpMethod.POST.name()).hasAuthority(RECIPE_WRITE.name())
                //.antMatchers("/api/v1/recipes/**", HttpMethod.GET.name()).hasAuthority(RECIPE_READ.name())
                //.antMatchers("/api/v1/ingredients/**", HttpMethod.GET.name()).hasAuthority(INGREDIENTS_READ.name())
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
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        UserDetails userUser = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .authorities(USER.getGrantedAuthorities())
                .build();
        UserDetails ingredientsBoss = User.builder()
                .username("tom")
                .password(passwordEncoder.encode("password"))
                .authorities(INGREDIENTS_MANAGER.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(isabellaUser, userUser, ingredientsBoss);
    }
}
