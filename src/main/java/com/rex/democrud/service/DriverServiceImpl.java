package com.rex.democrud.service;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;
import com.rex.democrud.model.entities.drivers.Driver;
import com.rex.democrud.repositories.DriverRepository;
import com.rex.democrud.service.exceptions.NotFoundException;
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
    public DriverDto updateDriver(Driver entity) throws NotFoundException {
        var optionalEntity = this.driverRepository.findById(entity.getId());
        if (optionalEntity.isEmpty()) throw new NotFoundException();
        Driver databaseEntity = optionalEntity.get();
        databaseEntity.setName(entity.getName());
        databaseEntity.setAge(entity.getAge());
        return new DriverDto(this.driverRepository.save(databaseEntity));
    }

    @Override
    public List<DriverDto> findAll() {
        return this.driverRepository.findAll()
                .stream()
                .map(DriverDto::new)
                .toList();
    }

    @Override
    public void deleteDriver(Long id) throws NotFoundException {
        var driver = this.driverRepository.findById(id);
        if (driver.isEmpty()) throw new NotFoundException("Entity " + id + " not found");
        this.driverRepository.deleteById(id);
    }
}
