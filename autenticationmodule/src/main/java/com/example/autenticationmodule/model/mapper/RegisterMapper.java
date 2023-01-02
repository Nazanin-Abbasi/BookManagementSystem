package com.example.autenticationmodule.model.mapper;

import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.model.User;

public class RegisterMapper {

    public static User toUser(RegisterRequest registerRequest){

        int accessLevel = 0;

        if(registerRequest.getUsername().equals("Admin"))
            accessLevel = 2;
        else if(registerRequest.getUsername().equals("Publisher"))
            accessLevel = 1;

        return new User(
                registerRequest.getFirstName(),
                registerRequest.getLastName(),
                registerRequest.getNationalNo(),
                registerRequest.getUsername(),
                registerRequest.getPassword(),
                accessLevel);

    }
}
