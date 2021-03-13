package com.example.zookeeper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @Mock
    AnimalRepository mockAnimalRepository;

    @InjectMocks
    AnimalService subject;


    @Test
    public void create() {
        AnimalDto animalDto = new AnimalDto("Tiger", "walking");
        subject.create(animalDto);
        verify(mockAnimalRepository).save(
                new AnimalEntity("Tiger", "walking")
        );

    }
}
