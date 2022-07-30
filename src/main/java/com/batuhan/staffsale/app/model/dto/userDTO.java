package com.batuhan.staffsale.app.model.dto;


import com.batuhan.staffsale.app.model.entity.Ad;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class userDTO {
    private String name;
    private String surname;
    private String email;
    private String username;
    private String password;
    private String phone;
}
