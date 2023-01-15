package com.v1project.MyDrugs.utils;

import com.v1project.MyDrugs.models.User;
import com.v1project.MyDrugs.models.dtos.UserDTO;

public class CreateUserTest {

    public static User createNewUserTest(){
        return new User(1, "userTest", "passTest");
    }

    public static UserDTO createNewUserDTOTest() {
        return UserDTO.builder()
                .id(1)
                .userName("userTest")
                .password("passTest")
                .build();
    }
}
