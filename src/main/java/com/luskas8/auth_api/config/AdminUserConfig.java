package com.luskas8.auth_api.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.luskas8.auth_api.entities.Role;
import com.luskas8.auth_api.entities.User;
import com.luskas8.auth_api.repository.RoleRepository;
import com.luskas8.auth_api.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
@Slf4j
public class AdminUserConfig implements CommandLineRunner {
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        var adminRole = roleRepository.findByName(Role.Values.ADMIN.name());
        var adminUser = userRepository.findByName("admin");
        adminUser.ifPresentOrElse(
            (user) -> {
                System.out.println("admin already exists");
            },
            () -> {
                User user = new User();
                user.setName("admin");
                var password = passwordEncoder.encode("admin");
                user.setPassword(password);
                user.setRoles(Set.of(adminRole));
                userRepository.save(user);
                System.out.println("admin created: " + user);
            }
        );
    }
}
