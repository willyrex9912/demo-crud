package com.rex.democrud.service;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;
import com.rex.democrud.model.entities.drivers.Driver;
import com.rex.democrud.service.exceptions.NotFoundException;

import java.util.List;

public interface DriverService {

    DriverDto createDriver(NewDriverDto entity);

    DriverDto updateDriver(Driver entity) throws NotFoundException;

    List<DriverDto> findAll();

    void deleteDriver(Long id) throws NotFoundException;

}
