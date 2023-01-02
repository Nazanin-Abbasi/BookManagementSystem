package com.example.autenticationmodule.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private Integer nationalNo;
    private String username;
    private String password;
    private int accessLevel;

}
