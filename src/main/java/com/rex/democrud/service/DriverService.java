package com.rex.democrud.service;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;
import com.rex.democrud.dto.UpdateDriverDto;
import com.rex.democrud.model.entities.drivers.Driver;
import com.rex.democrud.service.exceptions.DuplicatedException;
import com.rex.democrud.service.exceptions.NotFoundException;

import java.util.List;

public interface DriverService {

    DriverDto createDriver(NewDriverDto entity) throws DuplicatedException;

    DriverDto updateDriver(UpdateDriverDto entity) throws NotFoundException, DuplicatedException;

    List<DriverDto> findAll();

    void deleteDriver(Long id) throws NotFoundException;

}
