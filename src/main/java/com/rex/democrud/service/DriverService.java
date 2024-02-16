package com.rex.democrud.service;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;

import java.util.List;

public interface DriverService {

    DriverDto createDriver(NewDriverDto entity);

    List<DriverDto> findAll();

}
