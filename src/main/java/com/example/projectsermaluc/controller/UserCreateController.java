package com.example.projectsermaluc.controller;

import com.example.projectsermaluc.dto.request.UserRequest;
import com.example.projectsermaluc.dto.response.ApiResponse;
import com.example.projectsermaluc.dto.response.UserResponse;
import com.example.projectsermaluc.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@Tag(name = "UserCreateController", description = "Controlador para registrar el usuario y obtener su token")
public class UserCreateController {

    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserRequest userRequest) {
        ApiResponse<UserResponse> response = userService.createUser(userRequest);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

}
