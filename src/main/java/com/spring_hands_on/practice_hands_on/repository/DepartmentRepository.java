package com.spring_hands_on.practice_hands_on.repository;

import com.spring_hands_on.practice_hands_on.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
