package com.finclutech.backend.repository;

import com.finclutech.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
   // Check if an employee exists with the given email
   boolean existsByEmail(String email);
   List<Employee> findByDepartmentId(String departmentId);
   // Optional: Find employee by email
   Optional<Employee> findByEmail(String email);
}
