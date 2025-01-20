package com.finclutech.backend.config;

import com.finclutech.backend.user.Role;
import com.finclutech.backend.user.RoleRepository;
import com.finclutech.backend.user.RoleType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    @Transactional
    public void run(String... args) {
        seedRoles();
    }


    private void seedRoles() {
        // Iterate over RoleType enum values
        for (RoleType roleType : RoleType.values()) {
            roleRepository.findByRole(roleType).orElseGet(() -> {
                Role role = new Role();
                role.setRole(roleType); // Set the RoleType enum
                role.setDescription("Default description for " + roleType.getValue()); // Optional description
                return roleRepository.save(role);
            });
        }
    }
}
