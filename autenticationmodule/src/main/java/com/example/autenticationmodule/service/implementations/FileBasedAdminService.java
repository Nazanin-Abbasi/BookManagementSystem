package com.example.autenticationmodule.service.implementations;


import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.dto.response.DefaultResponse;
import com.example.autenticationmodule.dto.response.UserAdminArrayResponse;
import com.example.autenticationmodule.dto.response.UserAdminResponse;
import com.example.autenticationmodule.dto.response.UserArrayResponse;
import com.example.autenticationmodule.model.User;
import com.example.autenticationmodule.model.mapper.RegisterMapper;
import com.example.autenticationmodule.model.mapper.UserMapper;
import com.example.autenticationmodule.repository.FileRepository;
import com.example.autenticationmodule.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@Qualifier("FileBasedAdminServiceImpl")
public class FileBasedAdminService implements AdminService {

    private FileRepository fileRepository;

    @Autowired
    public FileBasedAdminService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public DefaultResponse addUser(RegisterRequest registerRequest) {
        boolean result = false;

        try {
            result =fileRepository.addUser(RegisterMapper.toUser(registerRequest));
        }catch (Exception exception){
            new DefaultResponse("Exception raised: " + exception.getMessage());
        }
        if(result)
            return new DefaultResponse("User registered successfully");
        return new DefaultResponse("Oops. Something went wrong");

    }

    @Override
    public UserAdminResponse removeUser(Integer nationalNo) {
        UserAdminArrayResponse userAdminArrayResponse = getAllUsers();
        UserAdminResponse response = new UserAdminResponse();
        boolean result = false;

        for (int i=0; i<userAdminArrayResponse.getUsers().size(); i++){
            if(userAdminArrayResponse.getUsers().get(i).getNationalNo().equals(nationalNo)){
                response = userAdminArrayResponse.getUsers().get(i);
                userAdminArrayResponse.getUsers().remove(i);
            }
        }

        try {
            result = fileRepository.writeAllUsers(UserMapper.toUserList(userAdminArrayResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result)
            return response;

        return null;
    }

    @Override
    public UserAdminResponse editUser(RegisterRequest registerRequest) {
        UserAdminArrayResponse userAdminArrayResponse = getAllUsers();
        UserAdminResponse response = new UserAdminResponse();
        boolean result = false;

        for(int i=0; i<userAdminArrayResponse.getUsers().size(); i++){
            if(userAdminArrayResponse.getUsers().get(i).getNationalNo().equals(registerRequest.getNationalNo())){
                userAdminArrayResponse.getUsers().get(i).setUsername(registerRequest.getUsername());
                userAdminArrayResponse.getUsers().get(i).setFirstName(registerRequest.getFirstName());
                userAdminArrayResponse.getUsers().get(i).setLastName(registerRequest.getLastName());
                userAdminArrayResponse.getUsers().get(i).setPassword(registerRequest.getPassword());
                userAdminArrayResponse.getUsers().get(i).setNationalNo(registerRequest.getNationalNo());

                response = userAdminArrayResponse.getUsers().get(i);
            }
        }

        try {
            result = fileRepository.writeAllUsers(UserMapper.toUserList(userAdminArrayResponse));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(result)
            return response;

        return null;
    }

    @Override
    public UserAdminArrayResponse getAllUsers() {
        try {
            List<User> users = fileRepository.getAllUsers();
            return UserMapper.convertToUserAdminArrayResponse(users);
        } catch (Exception exception){
            return new UserAdminArrayResponse();
        }
    }
}
