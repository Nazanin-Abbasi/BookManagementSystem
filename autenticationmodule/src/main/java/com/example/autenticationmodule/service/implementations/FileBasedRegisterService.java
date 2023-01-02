package com.example.autenticationmodule.service.implementations;

import com.example.autenticationmodule.dto.request.LoginRequest;
import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.dto.response.DefaultResponse;
import com.example.autenticationmodule.model.mapper.RegisterMapper;
import com.example.autenticationmodule.repository.FileRepository;
import com.example.autenticationmodule.service.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("FileBasedRegisterServiceImp")
public class FileBasedRegisterService implements RegisterService {
    private FileRepository fileRepository;


    @Autowired
    public FileBasedRegisterService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }


    @Override
    public DefaultResponse register(RegisterRequest registerRequest) {
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


}
