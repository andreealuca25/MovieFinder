package com.example.movie_finder.user;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<String> signup(@Valid @RequestBody User user) {
        userService.signup(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User signed up successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody User user) {
        return userService.login(user.getEmail(), user.getPassword())
                .map(authenticatedUser -> ResponseEntity.ok("User logged in successfully"))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"));
    }

    @GetMapping()
    public List<User> getUsers() {
        return userService.findAll();
    }
}
