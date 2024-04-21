package com.Kalisto.controller;

import com.Kalisto.Dto.RegisterDto;
import com.Kalisto.exceptions.EmailAlreadyExistsException;
import com.Kalisto.exceptions.PhoneAlreadyExistsException;
import com.Kalisto.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto) throws EmailAlreadyExistsException, PhoneAlreadyExistsException {
        try {
            authService.registerUser(registerDto);
            return ResponseEntity.ok("User registered successfully");
        } catch (EmailAlreadyExistsException | PhoneAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during registration");
        }
    }

}
