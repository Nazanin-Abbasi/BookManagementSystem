package com.example.autenticationmodule.service.interfaces;

import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.dto.response.DefaultResponse;
import com.example.autenticationmodule.dto.response.UserAdminArrayResponse;
import com.example.autenticationmodule.dto.response.UserAdminResponse;
import com.example.autenticationmodule.dto.response.UserResponse;
import com.example.autenticationmodule.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    public DefaultResponse addUser(RegisterRequest registerRequest);

    public UserAdminResponse removeUser(Integer nationalNo);

    public UserAdminResponse editUser(RegisterRequest registerRequest);

    public UserAdminArrayResponse getAllUsers();
}
