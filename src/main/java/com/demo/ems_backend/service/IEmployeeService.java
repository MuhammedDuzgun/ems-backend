package com.demo.ems_backend.service;

import com.demo.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface IEmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto);
    void deleteEmployee(Long employeeId);
}
