package com.rex.democrud.controller;

import com.rex.democrud.dto.driver.DriverDto;
import com.rex.democrud.dto.driver.NewDriverDto;
import com.rex.democrud.dto.driver.UpdateDriverDto;
import com.rex.democrud.service.DriverService;
import com.rex.democrud.service.exceptions.DuplicatedException;
import com.rex.democrud.service.exceptions.NotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("")
    public ResponseEntity<DriverDto> create(@Valid @RequestBody NewDriverDto entity) throws DuplicatedException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.driverService.createDriver(entity))
        ;
    }

    @PutMapping("")
    public ResponseEntity<DriverDto> update(@RequestBody UpdateDriverDto entity) throws NotFoundException, DuplicatedException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.driverService.updateDriver(entity))
        ;
    }

    @GetMapping("")
    public ResponseEntity<List<DriverDto>> findAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.driverService.findAll())
        ;
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<Void> delete(@PathVariable("driverId") Long id) throws NotFoundException {
        this.driverService.deleteDriver(id);
        return ResponseEntity.accepted().build();
    }

}
