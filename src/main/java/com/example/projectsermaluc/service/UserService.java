package com.example.projectsermaluc.service;

import com.example.projectsermaluc.dto.request.UserRequest;
import com.example.projectsermaluc.dto.response.ApiResponse;
import com.example.projectsermaluc.dto.response.UserResponse;
import com.example.projectsermaluc.entity.UserEntity;
import com.example.projectsermaluc.repository.UserRepository;
import com.example.projectsermaluc.security.jwt.JwtUtils;
import com.example.projectsermaluc.util.Constants;
import com.example.projectsermaluc.util.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtils jwtUtils;

    public ApiResponse createUser(UserRequest userRequest) {

        ApiResponse apiResponse = new ApiResponse();

        Optional<UserEntity> userExists = userRepository.findByEmailAndIsActive(userRequest.getEmail(), Constants.ACTIVE_FIELD);

        if (userExists.isPresent()) {
            apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
            apiResponse.setMensaje("El correo ya se encuentra registrado");
        } else {
            if (Utils.isValidEmail(userRequest.getEmail())) {
                LocalDateTime now = Utils.getCurrentDateTime();
                UserEntity user = new UserEntity();
                user.setName(userRequest.getName());
                user.setEmail(userRequest.getEmail());
                user.setPassword(userRequest.getPassword());
                user.setName(userRequest.getName());
                user.setCreated(now);
                user.setModified(now);
                user.setLastLogin(now);
                user.setIsActive(Constants.ACTIVE_FIELD);
                String token = jwtUtils.generateAccessToken(user.getEmail());
                user.setToken(token);
                userRepository.save(user);

                apiResponse.setStatusCode(HttpStatus.CREATED.value());
                apiResponse.setMensaje("Usuario registrado correctamente");
                apiResponse.setData(convertToUserResponse(user));
            } else {
                apiResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
                apiResponse.setMensaje("El correo no cumple con el formato correcto");
            }
        }
        return apiResponse;
    }

    private UserResponse convertToUserResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        BeanUtils.copyProperties(userEntity, userResponse);
        return userResponse;
    }

}
