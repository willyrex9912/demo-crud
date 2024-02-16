package com.rex.democrud.dto;

import com.rex.democrud.model.entities.drivers.Driver;
import lombok.Value;

@Value
public class DriverDto {

    Long id;
    String name;
    Integer age;

    public DriverDto(Driver driver) {
        this.id = driver.getId();
        this.name = driver.getName();
        this.age = driver.getAge();
    }

}
