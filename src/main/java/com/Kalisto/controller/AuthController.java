package com.Kalisto.controller;

import com.Kalisto.Dto.RegisterDto;
import com.Kalisto.service.AuthService;
import com.Kalisto.util.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PreAuthorize("permitAll()")
    @PostMapping("/register")
    public ResponseBody<Boolean> registerUser(@RequestBody RegisterDto registerDto){

        ResponseBody<Boolean> responseBody = new ResponseBody<>();
        if(authService.registerUser(registerDto)){
            responseBody.setBody(true);
            responseBody.setMessage("Regestered Sucessfully");
            return responseBody;
        }else{
             responseBody.setBody(false);
             return responseBody;
        }

    }

}
