package com.finclutech.backend.controller;


import com.finclutech.backend.dto.EmployeeDTO;
import com.finclutech.backend.service.EmployeeReportService;
import com.finclutech.backend.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeReportService employeeReportService;

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{departmentId}")
    public List<EmployeeDTO> getEmployeesByDepartment(@PathVariable String departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }

    @PostMapping("add/{departmentId}")
    public EmployeeDTO addEmployee(@PathVariable String departmentId, @RequestBody EmployeeDTO employeeDTO) {
        return employeeService.addEmployee(departmentId, employeeDTO);
    }

    @DeleteMapping("/{departmentId}/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @GetMapping("/emp/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id);

    }




    // Update Employee
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable String id,
            @RequestBody EmployeeDTO employeeDetails) {
        EmployeeDTO updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete Employee
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
