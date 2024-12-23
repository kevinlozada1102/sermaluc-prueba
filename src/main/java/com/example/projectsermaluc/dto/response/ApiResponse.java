package com.example.projectsermaluc.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiResponse<T> {

    @JsonIgnore
    private int statusCode;

    private String mensaje;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

}
