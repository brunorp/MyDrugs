package com.v1project.MyDrugs.services;

import com.v1project.MyDrugs.models.User;
import com.v1project.MyDrugs.models.dtos.UserDTO;
import com.v1project.MyDrugs.models.mappers.MapperInterface;
import com.v1project.MyDrugs.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private MapperInterface mapper;
    private User userTest;
    private UserDTO userDTOTest;
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(userRepository, mapper);
        userTest = createNewUserTest();
        userDTOTest = createNewUserDTOTest();
    }

    @Test
    void getAllUsers() {
        List<User> userList = Collections.singletonList(userTest);

        when(userRepository.findAll()).thenReturn(userList);
        when(mapper.toUserDTO(userTest)).thenReturn(userDTOTest);

        List<UserDTO> userDTOListRes = userService.getAllUsers();

        assertNotEquals(userDTOListRes.size(), 0);
    }

    private User createNewUserTest() {
        return new User(1, "userTest", "passTest");
    }
    private UserDTO createNewUserDTOTest() {
        return new UserDTO(1, "userTest", "passTest");
    }

}