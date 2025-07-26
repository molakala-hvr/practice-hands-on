package com.spring_hands_on.practice_hands_on.service;

import com.spring_hands_on.practice_hands_on.entity.Department;
import com.spring_hands_on.practice_hands_on.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private DepartmentRepository departmentRepository;

    @InjectMocks
    private DepartmentServiceImplementation departmentServiceImplementation;

    @Test
    public void testWithPostScenario() {
        Department department = Department.builder().departmentId(1l)
                                .departmentAddress("A-BLOCK").departmentName("ECE")
                                 .departmentCode("ECE0001").build();
        Mockito.when(departmentRepository.save(department)).thenReturn(department);
        Department output = departmentServiceImplementation.save(department);

        Assertions.assertEquals(department,output);


    }
}


