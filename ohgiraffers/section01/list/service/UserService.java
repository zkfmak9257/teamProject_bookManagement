package com.ohgiraffers.section01.list.service;

import com.ohgiraffers.section01.list.dto.UserDTO;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<UserDTO> userList = new ArrayList<>();

    public boolean register(UserDTO user) {
        if (findUserById(user.getUserId()) != null) return false;
        userList.add(user);
        return true;
    }

    public UserDTO login(String id, String pw) {
        for (UserDTO user : userList) {
            if (user.getUserId().equals(id) &&
                    user.getPassword().equals(pw)) {
                return user;
            }
        }
        return null;
    }

    public UserDTO findUserById(String id) {
        for (UserDTO user : userList) {
            if (user.getUserId().equals(id)) return user;
        }
        return null;
    }

    public List<UserDTO> getAllUsers() {
        return userList;
    }
}
