package com.rex.democrud.service;

import com.rex.democrud.dto.driver.DriverDto;
import com.rex.democrud.dto.driver.NewDriverDto;
import com.rex.democrud.dto.driver.UpdateDriverDto;
import com.rex.democrud.service.exceptions.DuplicatedException;
import com.rex.democrud.service.exceptions.NotFoundException;

import java.util.List;

public interface DriverService {

    DriverDto createDriver(NewDriverDto entity) throws DuplicatedException;

    DriverDto updateDriver(UpdateDriverDto entity) throws NotFoundException, DuplicatedException;

    List<DriverDto> findAll();

    void deleteDriver(Long id) throws NotFoundException;

}
