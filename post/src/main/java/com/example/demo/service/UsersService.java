package com.example.demo.service;

import com.example.demo.entity.Users;
import com.example.demo.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Autowired
    private UsersMapper usersMapper;

    public List<Users> findAll() {
        return usersMapper.findAll();
    }
}
