package com.example.autenticationmodule.controller;

import com.example.autenticationmodule.dto.request.LoginRequest;
import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.dto.response.DefaultResponse;
import com.example.autenticationmodule.dto.response.UserArrayResponse;
import com.example.autenticationmodule.service.interfaces.LoginService;
import com.example.autenticationmodule.service.interfaces.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping(path = "/authenticate")
public class AuthenticationController {

    @Autowired
    private @Qualifier("FileBasedRegisterServiceImp")
    RegisterService registerService;

    @Autowired
    private @Qualifier("FileBasedLoginServiceImp")
    LoginService loginService;


    @GetMapping("/register")
    public ModelAndView registerView(Model model){
        RegisterRequest registerRequest = new RegisterRequest();
        model.addAttribute("registerRequest", registerRequest);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public DefaultResponse register(@ModelAttribute("registerRequest") RegisterRequest registerRequest){
        DefaultResponse response = registerService.register(registerRequest);
        return response;
    }

    @GetMapping("/login")
    public ModelAndView loginView(Model model){
        LoginRequest loginRequest = new LoginRequest();
        model.addAttribute("loginRequest", loginRequest);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");;
        return modelAndView;
    }

    @PostMapping("/login")
    public DefaultResponse login(@ModelAttribute("loginRequest") LoginRequest loginRequest){
        DefaultResponse response = loginService.verifyUser(loginRequest);
        return response;
    }

}
