package com.example.backend.service.Impl;


import com.example.backend.dto.UserDTO;
import com.example.backend.entity.User;
import com.example.backend.exception.DataNotFoundException;

public interface ImplUserService {
    User createUser(UserDTO userDTO) throws Exception;

    String login(String phoneNumber, String password) throws Exception;
}
