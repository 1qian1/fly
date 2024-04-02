package com.example.demo.mapper;
import com.example.demo.entity.Users;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersMapper {
    List<Users> findAll();
}
