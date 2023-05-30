package com.example.demo.mapper;

import com.example.demo.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    public List<UserDTO> getUserList();
}
