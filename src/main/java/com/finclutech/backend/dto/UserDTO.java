package com.finclutech.backend.dto;

import com.finclutech.backend.user.RoleType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Set<RoleType> roles; // Use a Set to handle multiple roles

}

