package com.demo.ems_backend.service.impl;

import com.demo.ems_backend.dto.EmployeeDto;
import com.demo.ems_backend.entity.Employee;
import com.demo.ems_backend.mapper.EmployeeMapper;
import com.demo.ems_backend.repository.IEmployeeRepository;
import com.demo.ems_backend.service.IEmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

}
