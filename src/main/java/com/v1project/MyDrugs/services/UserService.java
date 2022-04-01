package com.v1project.MyDrugs.services;

import com.v1project.MyDrugs.models.User;
import com.v1project.MyDrugs.models.dtos.UserDTO;
import com.v1project.MyDrugs.models.mappers.MapperInterface;
import com.v1project.MyDrugs.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final MapperInterface mapper;

    @Autowired
    public UserService(UserRepository userRepository, MapperInterface mapper){
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.findAll().stream()
                .map(mapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO createUser(User user){
        return mapper.toUserDTO(userRepository.save(user));
    }
}
