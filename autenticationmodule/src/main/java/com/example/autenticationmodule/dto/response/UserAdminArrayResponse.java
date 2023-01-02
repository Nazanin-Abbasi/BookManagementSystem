package com.example.autenticationmodule.dto.response;

import lombok.Data;

import java.util.List;


@Data
public class UserAdminArrayResponse {
    private List<UserAdminResponse> users;
}
