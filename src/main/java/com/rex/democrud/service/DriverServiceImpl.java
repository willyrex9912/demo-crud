package com.rex.democrud.service;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;
import com.rex.democrud.model.entities.drivers.Driver;
import com.rex.democrud.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public DriverDto createDriver(NewDriverDto entity) {
        Driver driver = new Driver();
        driver.setName(entity.getName());
        driver.setAge(entity.getAge());
        this.driverRepository.save(driver);
        return new DriverDto(driver);
    }

    @Override
    public List<DriverDto> findAll() {
        return this.driverRepository.findAll()
                .stream()
                .map(DriverDto::new)
                .toList();
    }
}
