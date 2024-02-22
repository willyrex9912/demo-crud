package com.rex.democrud.service;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;
import com.rex.democrud.model.entities.drivers.Driver;
import com.rex.democrud.repositories.DriverRepository;
import com.rex.democrud.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void deleteDriver(Long id) throws EntityNotFoundException {
        var driver = this.driverRepository.findById(id);
        if (driver.isEmpty()) throw new EntityNotFoundException("Entity " + id + " not found");
        this.driverRepository.deleteById(id);
    }
}
