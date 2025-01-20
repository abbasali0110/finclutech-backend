package com.finclutech.backend.repository;


import com.finclutech.backend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    boolean existsById(String departmentId);
}

