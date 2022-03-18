package com.isbl.recipekeeper.auth;

import com.google.common.collect.Lists;
import com.isbl.recipekeeper.security.ApplicationUserRole;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoImpl implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    public FakeApplicationUserDaoImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers().stream().filter(applicationUser ->
            applicationUser.getUsername().equals(username)).findFirst();
    }

    private List<ApplicationUser> getApplicationUsers(){
        return Lists.newArrayList(
                new ApplicationUser("isabella",
                        "password",
                        ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                        ),
                new ApplicationUser("user",
                        passwordEncoder.encode("password"),
                        ApplicationUserRole.USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser("tom",
                        passwordEncoder.encode("password"),
                        ApplicationUserRole.INGREDIENTS_MANAGER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );

    }
}
