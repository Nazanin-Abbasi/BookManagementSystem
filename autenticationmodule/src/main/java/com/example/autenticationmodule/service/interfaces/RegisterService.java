package com.example.autenticationmodule.service.interfaces;

import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.dto.response.DefaultResponse;
import org.springframework.stereotype.Service;

@Service
public interface RegisterService {

    public DefaultResponse register(RegisterRequest registerRequest);

}
