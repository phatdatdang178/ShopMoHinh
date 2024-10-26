package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.dtos.UserDTO;
import com.example.ShopMoHinh.exceptions.DataNotFoundException;
import com.example.ShopMoHinh.models.User;
import org.springframework.stereotype.Service;


public interface iUserService {
    User createUser(UserDTO userDTO) throws DataNotFoundException;
    String login(String phoneNumber, String password);
}
