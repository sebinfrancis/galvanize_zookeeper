package com.example.zookeeper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ZooController {

    ArrayList<AnimalDto> animals;
    ZooController() {
        animals = new ArrayList<>();
    }
    @PostMapping("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimal(@RequestBody ArrayList<AnimalDto> animalDtos)
    {
        animalDtos.forEach((animal) -> {
            animals.add(animal);
        });
    }

    @GetMapping("/animals")
    public ArrayList<AnimalDto> getAnimals()
    {
        return animals;
    }
}
