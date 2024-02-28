package com.rex.democrud.service;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;
import com.rex.democrud.dto.UpdateDriverDto;
import com.rex.democrud.model.entities.drivers.Driver;
import com.rex.democrud.repositories.DriverRepository;
import com.rex.democrud.service.exceptions.DuplicatedException;
import com.rex.democrud.service.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    @Override
    public DriverDto createDriver(NewDriverDto entity) throws DuplicatedException {
        //Validation for duplicated name
        var optional = this.driverRepository.findByName(entity.getName());
        if (optional.isPresent()) throw new DuplicatedException("Name " + entity.getName() + " already registered");

        Driver driver = new Driver();
        driver.setName(entity.getName());
        driver.setAge(entity.getAge());
        this.driverRepository.save(driver);
        return new DriverDto(driver);
    }

    @Override
    public DriverDto updateDriver(UpdateDriverDto entity) throws NotFoundException, DuplicatedException {
        Driver databaseEntity = this.driverRepository.findById(entity.getId()).orElseThrow(NotFoundException::new);

        //Validation for duplicated name
        var optional = this.driverRepository.findByName(entity.getName());
        if (optional.isPresent()) {
            if(!optional.get().getId().equals(entity.getId())) throw new DuplicatedException("Name " + entity.getName() + " already registered");
        }

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
