package com.v1project.MyDrugs.controllers;

import com.v1project.MyDrugs.models.User;
import com.v1project.MyDrugs.models.dtos.UserDTO;
import com.v1project.MyDrugs.services.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.v1project.MyDrugs.utils.CreateUserTest.createNewUserDTOTest;
import static com.v1project.MyDrugs.utils.CreateUserTest.createNewUserTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;
    @Mock
    private UserService userService;

    @Test
    public void shouldReturnAllUsers(){
        List<UserDTO> userDTOList = List.of(createNewUserDTOTest());
        ResponseEntity<List<UserDTO>> expected = ResponseEntity.ok().body(userDTOList);

        when(userService.getAllUsers()).thenReturn(userDTOList);

        ResponseEntity<List<UserDTO>> actual = userController.getAllUsers();

        verify(userService, times(1)).getAllUsers();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateUser(){
        User user = createNewUserTest();
        UserDTO userDTO = createNewUserDTOTest();
        ResponseEntity<UserDTO> expected = ResponseEntity.ok().body(userDTO);

        when(userService.createUser(user)).thenReturn(userDTO);

        ResponseEntity<UserDTO> actual = userController.createUser(user);

        verify(userService, times(1)).createUser(user);
        assertEquals(expected, actual);
    }
}
