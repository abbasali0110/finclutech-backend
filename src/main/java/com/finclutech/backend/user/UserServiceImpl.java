package com.finclutech.backend.user;

import com.finclutech.backend.dto.JwtRequest;
import com.finclutech.backend.dto.UserDTO;
import com.finclutech.backend.exceptions.UserAlreadyExistsException;
import com.finclutech.backend.security.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class  UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AuthenticationProvider authenticationProvider;
    private final JwtTokenUtil jwtTokenUtil;
    private final RoleRepository roleRepository;

    @Override
    public User createUser(UserDTO userDTO) {
        String username = userDTO.getUsername();
        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            throw new UserAlreadyExistsException("Username " + username + " already exists.");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFirstname(userDTO.getFirstName());
        user.setLastname(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        Set<Role> roles = new HashSet<>();
        for (RoleType roleType : userDTO.getRoles()) {
            Role role = roleRepository.findByRole(roleType)
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleType));
            roles.add(role);
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }

    @Override
    public String login(JwtRequest jwtRequest) {
        final Authentication authentication = authenticationProvider.authenticate(
                new UsernamePasswordAuthenticationToken(
                        jwtRequest.getUsername(),
                        jwtRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userRepository.findByUsername(jwtRequest.getUsername());
        return jwtTokenUtil.generateToken(user.getUsername());
    }


    @Override
    public User getUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(userDetails.getUsername());
    }
}
