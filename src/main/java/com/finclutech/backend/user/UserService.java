package com.finclutech.backend.user;



import com.finclutech.backend.dto.JwtRequest;
import com.finclutech.backend.dto.UserDTO;

public interface UserService {
    User createUser(UserDTO userDTO);
    String login(JwtRequest jwtRequest);
    User getUser();
}
