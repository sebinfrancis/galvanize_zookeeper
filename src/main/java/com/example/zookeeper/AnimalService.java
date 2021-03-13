package com.example.zookeeper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public void createMany(List<AnimalDto> animals) {

        animalRepository.saveAll(animals
                .stream()
                .map(animal -> {
                    return new AnimalEntity(animal.getName(), animal.getType());
                })
                .collect(Collectors.toList())
                );
    }
}
