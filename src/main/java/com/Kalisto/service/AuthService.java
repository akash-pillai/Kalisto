package com.Kalisto.service;

import com.Kalisto.Dto.RegisterDto;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public boolean registerUser(RegisterDto registerDto);
}
