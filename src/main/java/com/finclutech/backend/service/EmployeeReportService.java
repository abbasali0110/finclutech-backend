package com.finclutech.backend.service;

import com.finclutech.backend.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeReportService {

    private final DepartmentRepository departmentRepository;
}
