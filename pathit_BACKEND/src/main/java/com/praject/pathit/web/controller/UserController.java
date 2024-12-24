package com.praject.pathit.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.praject.pathit.dao.repositories.UserRepository;
import com.praject.pathit.web.model.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/pathit")
@RequiredArgsConstructor // Génère un constructeur pour les final fields
@CrossOrigin(origins = "http://127.0.0.1:3000") // Gérer CORS au niveau du contrôleur
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Email already exists. Please try again.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User registered successfully with email: " + user.getEmail());
    }
}
