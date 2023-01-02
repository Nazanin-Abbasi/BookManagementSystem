package com.example.autenticationmodule.controller;


import com.example.autenticationmodule.dto.request.RegisterRequest;
import com.example.autenticationmodule.dto.response.DefaultResponse;
import com.example.autenticationmodule.dto.response.UserAdminArrayResponse;
import com.example.autenticationmodule.dto.response.UserAdminResponse;
import com.example.autenticationmodule.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/admin")
public class UserController {

    @Autowired
    private @Qualifier("FileBasedAdminServiceImpl")
    AdminService adminService;

    @PostMapping("/add")
    public DefaultResponse addUser(@RequestBody RegisterRequest registerRequest,
                                   @RequestParam (name = "username") String username){
        if(username.equals("Admin")){
            DefaultResponse response = adminService.addUser(registerRequest);
            return response;
        }

        return null;
    }

    @GetMapping("/remove")
    public UserAdminResponse removeUser(@RequestParam (name = "national_number") Integer nationalNo,
                                        @RequestParam (name = "username") String username){
        if(username.equals("Admin")){
            UserAdminResponse response = adminService.removeUser(nationalNo);
            return response;
        }

        return null;
    }

    @PostMapping("/edit")
    public UserAdminResponse editUser(@RequestBody RegisterRequest registerRequest,
                                      @RequestParam (name = "username") String username){
        if(username.equals("Admin")){
            UserAdminResponse response = adminService.editUser(registerRequest);
            return response;
        }

        return null;
    }

    @GetMapping("/show_all")
    public UserAdminArrayResponse showAll(@RequestParam (name = "username") String username){
        if(username.equals("Admin")){
            UserAdminArrayResponse users = adminService.getAllUsers();
            return users;
        }

        return null;
    }


}
