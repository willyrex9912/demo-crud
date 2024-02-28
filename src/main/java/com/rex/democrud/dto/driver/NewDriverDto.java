package com.rex.democrud.dto.driver;

import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class NewDriverDto {

    @NotNull
    String name;

    @NotNull
    Integer age;

}
