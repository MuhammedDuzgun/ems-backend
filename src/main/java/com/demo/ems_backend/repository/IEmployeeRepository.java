package com.demo.ems_backend.repository;

import com.demo.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
