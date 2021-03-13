package com.example.zookeeper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZooController {
    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimal()
    {

    }
}
