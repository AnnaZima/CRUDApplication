package com.anya.crudapp.service;

import com.anya.crudapp.model.Specialty;
import com.anya.crudapp.model.Status;
import com.anya.crudapp.repository.SpecialtyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpecialtyServiceTest {

    @Mock
    SpecialtyRepository specialtyRepository;
    @InjectMocks
    SpecialtyService specialtyService;

    private Specialty getSpecialty() {
        return new Specialty(1, "java", Status.ACTIVE);
    }

    @Test
    void getSpecialtyById() {
        when(specialtyRepository.getById(anyInt())).thenReturn(getSpecialty());
        Specialty specialty = specialtyService.getSpecialtyById(1);
        Assertions.assertEquals("java", specialty.getName());

    }

    @Test
    void saveSpecialty() {
        when(specialtyRepository.addToDatabase(any(Specialty.class))).thenReturn(getSpecialty());
        Specialty specialty = specialtyService.saveSpecialty(new Specialty());
        Assertions.assertEquals("java", specialty.getName());

    }

    @Test
    void updateSpecialty() {
        when(specialtyRepository.updateObject(any(Specialty.class))).thenReturn(getSpecialty());
        Specialty specialty = specialtyService.updateSpecialty(new Specialty());
        Assertions.assertEquals("java", specialty.getName());
    }

    @Test
    void deleteSpecialty() {
        SpecialtyService specialtyService1 = Mockito.mock(SpecialtyService.class);
        doNothing().when(specialtyService1).deleteSpecialty(1);
    }


}
