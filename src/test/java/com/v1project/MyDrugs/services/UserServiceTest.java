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

import static com.v1project.MyDrugs.utils.CreateUserTest.createNewUserDTOTest;
import static com.v1project.MyDrugs.utils.CreateUserTest.createNewUserTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
    public void shouldGetAllUsers() {
        List<User> userList = Collections.singletonList(userTest);

        when(userRepository.findAll()).thenReturn(userList);
        when(mapper.toUserDTO(userTest)).thenReturn(userDTOTest);

        List<UserDTO> userDTOListRes = userService.getAllUsers();

        assertNotEquals(userDTOListRes.size(), 0);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void shouldCreateUser(){
        when(userRepository.save(userTest)).thenReturn(userTest);
        when(mapper.toUserDTO(userTest)).thenReturn(userDTOTest);

        UserDTO userDTO = userService.createUser(userTest);

        assertEquals(userDTO, userDTOTest);
        verify(userRepository, times(1)).save(any(User.class));
    }
}