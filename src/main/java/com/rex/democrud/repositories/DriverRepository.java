package com.rex.democrud.repositories;

import com.rex.democrud.model.entities.drivers.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long> {

    List<Driver> findAll();

    Optional<Driver> findFirstByName(String name);

    Optional<Driver> findFirstByNameAndIdNot(String name, Long id);

}
