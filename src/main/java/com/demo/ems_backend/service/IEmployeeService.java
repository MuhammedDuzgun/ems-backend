package com.demo.ems_backend.service;

import com.demo.ems_backend.dto.EmployeeDto;

public interface IEmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long employeeId);
}
