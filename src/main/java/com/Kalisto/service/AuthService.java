package com.Kalisto.service;

import com.Kalisto.Dto.RegisterDto;
import com.Kalisto.exceptions.EmailAlreadyExistsException;
import com.Kalisto.exceptions.PhoneAlreadyExistsException;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public void registerUser(RegisterDto registerDto) throws EmailAlreadyExistsException, PhoneAlreadyExistsException;
}
