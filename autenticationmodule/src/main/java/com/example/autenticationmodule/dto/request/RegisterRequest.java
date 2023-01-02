package com.example.autenticationmodule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest{
    private String firstName;
    private String lastName;
    private Integer nationalNo;
    private String username;
    private String password;

}
