package com.example.autenticationmodule.service.implementations;

import com.example.autenticationmodule.dto.request.LoginRequest;
import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.dto.response.DefaultResponse;
import com.example.autenticationmodule.dto.response.UserArrayResponse;
import com.example.autenticationmodule.dto.response.UserResponse;
import com.example.autenticationmodule.model.User;
import com.example.autenticationmodule.model.mapper.UserMapper;
import com.example.autenticationmodule.repository.FileRepository;
import com.example.autenticationmodule.service.interfaces.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("FileBasedLoginServiceImp")
public class FileBasedLoginService implements LoginService {

    private FileRepository fileRepository;

    @Autowired
    public FileBasedLoginService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public UserArrayResponse getAllUsers() {
        try{
            List<User> userList = fileRepository.getAllUsers();
            return UserMapper.convertToUserArrayResponse(userList);
        }catch (Exception exception){
            return new UserArrayResponse();
        }
    }

    @Override
    public DefaultResponse verifyUser(LoginRequest loginRequest) {
        UserArrayResponse userArrayResponses = getAllUsers();

        for (int i=0; i< userArrayResponses.getUsers().size(); i++){
             if(userArrayResponses.getUsers().get(i).getUsername().equals(loginRequest.getUsername())){
                 if(userArrayResponses.getUsers().get(i).getPassword().equals(loginRequest.getPassword()))
                     return new DefaultResponse("User logged in");
             }
        }
        return null;
    }
}
