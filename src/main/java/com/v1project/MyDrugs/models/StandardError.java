package com.v1project.MyDrugs.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class StandardError {

    private LocalDateTime dateTime;
    private Integer status;
    private String error;
    private String path;
}
