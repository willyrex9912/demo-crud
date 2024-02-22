package com.rex.democrud.controller;

import com.rex.democrud.dto.DriverDto;
import com.rex.democrud.dto.NewDriverDto;
import com.rex.democrud.service.DriverService;
import com.rex.democrud.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping("")
    public ResponseEntity<DriverDto> create(@RequestBody NewDriverDto entity){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.driverService.createDriver(entity))
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
    public ResponseEntity<Void> delete(@PathVariable("driverId") Long id) throws EntityNotFoundException {
        this.driverService.deleteDriver(id);
        return ResponseEntity.accepted().build();
    }

}
