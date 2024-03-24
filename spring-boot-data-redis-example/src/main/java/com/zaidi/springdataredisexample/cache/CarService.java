package com.zaidi.springdataredisexample.cache;

import java.util.Arrays;
import java.util.List;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    private static final List<Car> cars =  Arrays.asList(new Car(1L, "Volvo", 2009), new Car(2L, "Toyota", 2017), new Car(3L, "Ford", 2015));

    @Cacheable(value = "cars")
    public List<Car> getAll() throws InterruptedException {
        System.out.println("Fetching data without cache");
        Thread.sleep(3000L);
        return cars;
    }

    @CacheEvict(value = "cars")
    public void deleteAll() {

    }


    @Cacheable(value = "car", key = "#id")
    public Car getById(Long id) {
        System.out.println("Fetching data without cache");
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @CacheEvict(value = "car", key = "#id")
    public void deleteById(Long id) {

    }

}
