package com.finclutech.backend.controller;

import com.finclutech.backend.dto.UserDTO;
import com.finclutech.backend.user.User;
import com.finclutech.backend.user.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/users")
@Tag(name = "API for managing users", description="")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    // APi 1
    @PostMapping("/create")
    @Operation(summary = "Creates user", description = "Returns created user")
    public User createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

}
