package com.springai.MCPServer.dto;

import lombok.Data;

@Data
public class UserResponseDto {

    private Long id;

    private String name;

    private String email;

    private Integer age;

    private String city;
}
