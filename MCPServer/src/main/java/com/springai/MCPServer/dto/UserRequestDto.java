package com.springai.MCPServer.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;

    @Min(value = 1, message = "Age must be positive")
    private Integer age;

    @NotBlank(message = "City is required")
    private String city;
}
