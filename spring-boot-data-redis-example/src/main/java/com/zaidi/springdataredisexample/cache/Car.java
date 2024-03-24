package com.zaidi.springdataredisexample.cache;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car implements Serializable {

    @Serial
    private static final long serialVersionUID = 2712481246L;

    private Long id;
    private String brand;
    private Integer year;

}
