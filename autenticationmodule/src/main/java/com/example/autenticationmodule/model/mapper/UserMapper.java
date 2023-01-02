package com.example.autenticationmodule.model.mapper;

import com.example.autenticationmodule.dto.response.UserAdminArrayResponse;
import com.example.autenticationmodule.dto.response.UserAdminResponse;
import com.example.autenticationmodule.dto.response.UserArrayResponse;
import com.example.autenticationmodule.dto.response.UserResponse;
import com.example.autenticationmodule.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserArrayResponse convertToUserArrayResponse(List<User> users) {
        UserArrayResponse userArrayResponse = new UserArrayResponse();
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user: users)
            userResponses.add(toUserResponse(user));

        userArrayResponse.setUsers(userResponses);
        return userArrayResponse;
    }

    public static UserResponse toUserResponse(User user){

        return new UserResponse(user.getNationalNo(), user.getUsername(), user.getPassword());
    }

    public static UserAdminArrayResponse convertToUserAdminArrayResponse(List<User> users){
        UserAdminArrayResponse userAdminArrayResponse = new UserAdminArrayResponse();
        List<UserAdminResponse> userAdminResponses = new ArrayList<>();

        for (User user: users)
            userAdminResponses.add(toUserAdminResponse(user));

        userAdminArrayResponse.setUsers(userAdminResponses);
        return userAdminArrayResponse;

    }

    public static UserAdminResponse toUserAdminResponse(User user){
        return new UserAdminResponse(user.getFirstName(),
                user.getLastName(),
                user.getNationalNo(),
                user.getUsername(),
                user.getPassword(),
                user.getAccessLevel());

    }

    public static List<User> toUserList(UserAdminArrayResponse userAdminArrayResponse){
        List<User> users = new ArrayList<>();

        for (int i=0; i<userAdminArrayResponse.getUsers().size(); i++)
            users.add(toUser(userAdminArrayResponse.getUsers().get(i)));

        return users;

    }

    public static User toUser(UserAdminResponse userAdminResponse){
        return new User(userAdminResponse.getFirstName(),
                userAdminResponse.getLastName(),
                userAdminResponse.getNationalNo(),
                userAdminResponse.getUsername(),
                userAdminResponse.getPassword(),
                userAdminResponse.getAccessLevel());
    }
}
