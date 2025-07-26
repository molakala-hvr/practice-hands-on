package com.spring_hands_on.practice_hands_on.service;

import com.spring_hands_on.practice_hands_on.entity.Department;
import com.spring_hands_on.practice_hands_on.error.DepartmentNotFoundException;
import com.spring_hands_on.practice_hands_on.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository repository;
    @Override
    public Department save(Department department) {

        return repository.save(department);
    }

    @Override
    public List<Department> fetch() {
        return repository.findAll();
    }

    @Override
    public Department fetchById(Long departmentId) throws DepartmentNotFoundException {

        Optional<Department> department = repository.findById(departmentId);
        if(!department.isPresent()){
            throw new DepartmentNotFoundException("department not found");
        }
        return department.get();
    }

    @Override
    public void deleteById(Long departmentId) {
        repository.deleteById(departmentId);
    }

    @Override
    public Department updateById(Long departmentId, Department department) {
       Department depvalue = repository.findById(departmentId).get();

           if(Objects.nonNull(department.getDepartmentAddress()) &&
                   !"".equalsIgnoreCase(department.getDepartmentAddress())){
               depvalue.setDepartmentAddress(department.getDepartmentAddress());
           }

           if(Objects.nonNull(department.getDepartmentName()) &&
                   !"".equalsIgnoreCase(department.getDepartmentName())){
               depvalue.setDepartmentName(department.getDepartmentName());
           }

           if(Objects.nonNull(department.getDepartmentCode()) &&
                   !"".equalsIgnoreCase(department.getDepartmentCode())){
               depvalue.setDepartmentCode(department.getDepartmentCode());
           }


       return repository.save(depvalue);
    }

}
