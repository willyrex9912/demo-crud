package com.rex.democrud.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class NewDriverDto {

    @NotNull
    String name;

    @NotNull
    Integer age;

}
