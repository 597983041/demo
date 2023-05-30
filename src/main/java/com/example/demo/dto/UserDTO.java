package com.example.demo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    Integer id;
    String name;
    String password;

}
