package com.finclutech.backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDTO {
    private String id;
    private String name;
    private String email;
    private String position;
    private double salary;
    private String department;


}
