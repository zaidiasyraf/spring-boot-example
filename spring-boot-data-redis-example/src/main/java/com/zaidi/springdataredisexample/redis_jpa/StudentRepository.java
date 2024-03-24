package com.zaidi.springdataredisexample.redis_jpa;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    Optional<Student> findByName(String name);

}
