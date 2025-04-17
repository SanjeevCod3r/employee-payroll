package com.bridgelabz.employeepayroll.services;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.model.Employee;

import java.util.List;

public interface IEmployeeServices {
    Employee createEmployee(EmployeeDTO employeeDTO);
    List<Employee> getEmployee();
    Employee getEmployeeByID(Long id);
    Employee updateEmployee(Long id,EmployeeDTO employeeDTO);
    void deleteEmployee(Long id);
}