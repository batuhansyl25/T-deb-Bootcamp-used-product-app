package com.batuhan.staffsale.app.services;


import com.batuhan.staffsale.app.model.dto.userDTO;
import com.batuhan.staffsale.app.model.entity.User;
import com.batuhan.staffsale.app.model.mapper.userMapper;
import com.batuhan.staffsale.app.repository.UserRepository;
import com.batuhan.staffsale.app.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

@Service
@RequiredArgsConstructor
public class UserServices {


    private final UserRepository userRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;


    public User create(userDTO userdto){
        userdto.setPassword(passwordEncoder.encode(userdto.getPassword()));
        User user = userMapper.toEntity(userdto);
        return userRepository.save(user);
    }

    public String login(String username, String password){
        try {
            User user = userRepository.findByUsername(username);
            Boolean passwordMatch = passwordEncoder.matches(password,user.getPassword());;
            return jwtTokenProvider.createToken(username);
        } catch (Exception e) {
            return ("Invalid username/password supplied");
        }
    }
    public userDTO getUser(Long userId){
        User userById = userRepository.getById(userId);
        userDTO userdto = userMapper.toDTO(userById);
        return userdto;
    }

    public Boolean deleteUserById(Long userId){
        try {
            userRepository.deleteById(userId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
