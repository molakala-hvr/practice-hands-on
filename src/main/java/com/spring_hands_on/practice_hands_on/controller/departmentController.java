package com.spring_hands_on.practice_hands_on.controller;

import com.spring_hands_on.practice_hands_on.entity.Department;
import com.spring_hands_on.practice_hands_on.error.DepartmentNotFoundException;
import com.spring_hands_on.practice_hands_on.service.DepartmentService;
import jakarta.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class departmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/save")
    public Department saveDepartment(@Valid @RequestBody Department department){
        log.info("inside saving data");
        return departmentService.save(department);
    }

    @GetMapping("/fetch")
    public List<Department> fetchDepartmentList(){
       return departmentService.fetch();
    }

    @GetMapping("fetch/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return departmentService.fetchById(departmentId);
    }

    @DeleteMapping("delete/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteById(departmentId);
        return "department deleted successfully";
    }

    @PutMapping("update/{id}")
    public Department updateDepartmentById(@PathVariable("id")Long departmentId, @RequestBody Department department){
        return departmentService.updateById(departmentId, department);
    }
}
