package com.example.autenticationmodule.service.interfaces;

import com.example.autenticationmodule.dto.request.LoginRequest;
import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.dto.response.DefaultResponse;
import com.example.autenticationmodule.dto.response.UserArrayResponse;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    public UserArrayResponse getAllUsers();
    public DefaultResponse verifyUser(LoginRequest loginRequest);

}
