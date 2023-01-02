package com.example.autenticationmodule.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class UserArrayResponse {
    private List<UserResponse> users;
}
