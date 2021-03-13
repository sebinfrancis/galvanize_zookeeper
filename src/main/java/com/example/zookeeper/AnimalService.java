package com.example.zookeeper;

import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    public void create(AnimalDto animalDto) {

        animalRepository.save(
                new AnimalEntity(animalDto.getName(), animalDto.getType())
        );
    }
}
