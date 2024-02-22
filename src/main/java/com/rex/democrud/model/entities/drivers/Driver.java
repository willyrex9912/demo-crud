package com.rex.democrud.model.entities.drivers;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the driver database table.
 * @author willyrex
 */

@Entity(name = "driver")
@Getter
@Setter
@NoArgsConstructor
public class Driver {

    @Id
    @Column(name = "id")
    @SequenceGenerator(name = "driverIdGenerator", sequenceName = "SEQ_DRIVER", allocationSize = 1, initialValue = 10000)
    @GeneratedValue(generator = "driverIdGenerator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "age")
    private Integer age;

}
