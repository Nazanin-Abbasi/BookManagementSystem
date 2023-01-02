package com.example.autenticationmodule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAdminResponse {

    private String firstName;
    private String lastName;
    private Integer nationalNo;
    private String username;
    private String password;
    private int accessLevel;
}
