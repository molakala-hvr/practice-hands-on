package com.spring_hands_on.practice_hands_on.service;

import com.spring_hands_on.practice_hands_on.entity.Department;
import com.spring_hands_on.practice_hands_on.error.DepartmentNotFoundException;
import com.spring_hands_on.practice_hands_on.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {

    @InjectMocks
    private DepartmentServiceImplementation departmentService;

    @Mock
    DepartmentRepository departmentRepository;

    Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder().departmentCode("ECE0001").departmentName("ECE")
                      .departmentAddress("D-Block").departmentId(1l).build();
    }
    @Test
    public void testFetchByIdReturnsDepartment() throws DepartmentNotFoundException {
        long departmentId = 1l;
        when(departmentRepository.findById(1l)).thenReturn(Optional.ofNullable(department));
        Department out1 = departmentService.fetchById(departmentId);
        assertEquals(departmentId, out1.getDepartmentId());

    }

    @Test
    public void testFetchByIdReturnsException() throws DepartmentNotFoundException {
        long departmentId = 1l;
        when(departmentRepository.findById(0l)).thenReturn(Optional.empty());
       assertThrows(DepartmentNotFoundException.class, ()->
       {
           departmentService.fetchById(departmentId);
       });

    }


}