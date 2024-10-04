package com.demo.ems_backend.service.impl;

import com.demo.ems_backend.dto.EmployeeDto;
import com.demo.ems_backend.entity.Employee;
import com.demo.ems_backend.exception.ResourceNotFoundException;
import com.demo.ems_backend.mapper.EmployeeMapper;
import com.demo.ems_backend.repository.IEmployeeRepository;
import com.demo.ems_backend.service.IEmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()-> new ResourceNotFoundException("Employee with id " + employeeId + " not found"));
        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto employeeDto) {
        Employee employeeToUpdate = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee with id " + employeeId + " not found")
        );
        employeeToUpdate.setFirstName(employeeDto.getFirstName());
        employeeToUpdate.setLastName(employeeDto.getLastName());
        employeeToUpdate.setEmail(employeeDto.getEmail());
        Employee savedEmployee = employeeRepository.save(employeeToUpdate);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employeeToDelete = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " + employeeId + " not found"));
        employeeRepository.delete(employeeToDelete);
    }

}
