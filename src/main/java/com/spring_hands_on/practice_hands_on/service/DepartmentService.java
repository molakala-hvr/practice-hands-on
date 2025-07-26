package com.spring_hands_on.practice_hands_on.service;

import com.spring_hands_on.practice_hands_on.entity.Department;
import com.spring_hands_on.practice_hands_on.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public  Department save(Department department);

   public List<Department> fetch();

    public Department fetchById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteById(Long departmentId);

    public Department updateById(Long departmentId, Department department);
}
