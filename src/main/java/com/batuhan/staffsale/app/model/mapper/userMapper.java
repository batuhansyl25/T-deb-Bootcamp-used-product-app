package com.batuhan.staffsale.app.model.mapper;

import com.batuhan.staffsale.app.model.dto.userDTO;
import com.batuhan.staffsale.app.model.entity.User;

public class userMapper {

    public static User toEntity(userDTO userdto)
    {
        User user = new User();
        user.setName(userdto.getName());
        user.setSurname(userdto.getSurname());
        user.setPhone(userdto.getPhone());
        user.setEmail(userdto.getEmail());
        user.setPassword(userdto.getPassword());
        user.setUsername(userdto.getUsername());
        return user;
    }

    public static  userDTO toDTO(User user){
        userDTO userdto = new userDTO();
        userdto.setEmail(user.getEmail());
        userdto.setName(user.getName());
        userdto.setSurname(user.getSurname());
        userdto.setPhone(user.getPhone());
        userdto.setUsername(user.getUsername());
        return userdto;
    }
}
