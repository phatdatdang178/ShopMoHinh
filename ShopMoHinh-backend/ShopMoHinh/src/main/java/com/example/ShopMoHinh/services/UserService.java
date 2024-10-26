package com.example.ShopMoHinh.services;

import com.example.ShopMoHinh.Repositories.RoleRepository;
import com.example.ShopMoHinh.Repositories.UserRepository;
import com.example.ShopMoHinh.dtos.UserDTO;
import com.example.ShopMoHinh.exceptions.DataNotFoundException;
import com.example.ShopMoHinh.models.Role;
import com.example.ShopMoHinh.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements iUserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User createUser(UserDTO userDTO) throws DataNotFoundException {
        String phoneNumber = userDTO.getPhoneNumber();
        //Kiem tra so dien thoai ton tai hay chua
        if(userRepository.existsByPhoneNumber(phoneNumber)){
            throw new DataIntegrityViolationException("Phone number already exists");
        }
        User newUser = User.builder()
                .fullName(userDTO.getFullName())
                .phoneNumber(phoneNumber)
                .password(userDTO.getPassword())
                .address(userDTO.getAddress())
                .dateOfBirth(userDTO.getDateOfBirth())
                .facebookAccountId(userDTO.getFacebookAccountId())
                .googleAccountId(userDTO.getGoogleAccountId())
                .build();
        Role role = roleRepository.findById(userDTO.getRoleId())
                .orElseThrow(() -> new DataNotFoundException("Role not found"));
        newUser.setRole(role);
        //Kiem tra neu co accountId, khong yeu cau password
        if (userDTO.getFacebookAccountId()==0 && userDTO.getGoogleAccountId()==0){
            String password = userDTO.getPassword();
//            String encodedPassword = passwordEncoder.encode(password);
//            newUser.setPassword(encodedPassword);
        }
        return userRepository.save(newUser);
    }

    @Override
    public String login(String phoneNumber, String password) {
        return null;
    }
}
