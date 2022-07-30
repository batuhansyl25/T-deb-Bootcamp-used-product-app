package com.batuhan.staffsale.app.controller;


import com.batuhan.staffsale.app.model.dto.userDTO;
import com.batuhan.staffsale.app.model.dto.userLoginDTO;
import com.batuhan.staffsale.app.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.batuhan.staffsale.app.services.UserServices;

@RestController
@RequestMapping("/api/docs/user")
public class staffController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/register")
    public ResponseEntity createUser(@RequestBody userDTO userdto) {
        User user = userServices.create(userdto);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USER NOT CREATED");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody userLoginDTO userLogindto){
        return userServices.login(userLogindto.getUsername(), userLogindto.getPassword());
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Long id) {
        userDTO userGetId = userServices.getUser(id);
        if (userGetId == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USER NOT FOUND");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userGetId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserById(@PathVariable("id") Long id) {
        Boolean delete = userServices.deleteUserById(id);
        if (delete == false) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("USER NOT FOUND");
        }
        return ResponseEntity.status(HttpStatus.OK).body("USER SUCCESSFULLY DELETED");
    }

}
