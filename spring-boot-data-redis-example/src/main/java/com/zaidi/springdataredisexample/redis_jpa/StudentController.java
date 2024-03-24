package com.zaidi.springdataredisexample.redis_jpa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/id/{id}")
    public Student getById(@PathVariable Long id) {
        return studentRepository.findById(id).get();
    }

    @GetMapping("/name/{name}")
    public Student getByName(@PathVariable String name) {
        return studentRepository.findByName(name).get();
    }

}
