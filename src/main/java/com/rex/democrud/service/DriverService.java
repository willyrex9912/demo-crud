package com.rex.democrud.service;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;
import com.rex.democrud.service.exceptions.EntityNotFoundException;

import java.util.List;

public interface DriverService {

    DriverDto createDriver(NewDriverDto entity);

    List<DriverDto> findAll();

    void deleteDriver(Long id) throws EntityNotFoundException;

}
