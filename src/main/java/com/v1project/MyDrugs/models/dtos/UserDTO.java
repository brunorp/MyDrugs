package com.v1project.MyDrugs.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public record UserDTO(Integer id,
        String userName,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) String password) {
    @Builder public UserDTO{}
}
