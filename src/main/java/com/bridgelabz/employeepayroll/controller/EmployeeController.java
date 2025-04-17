package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmployeeDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServices employeeService;

    @PostMapping
    public ResponseDTO createEmployee(@RequestBody EmployeeDTO employeeDTO) {
      Employee employee = employeeService.createEmployee(employeeDTO);
      return new ResponseDTO("Employee created successfully", employeeDTO);
    }

    @GetMapping
    public ResponseDTO getEmployees() {
        List<Employee> employee = employeeService.getEmployee();
        return new ResponseDTO("Employee list", employee);
    }

    @GetMapping("/{id}")
    public ResponseDTO getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeByID(id);
        return new ResponseDTO("Employee details", employee);
    }

    @PutMapping("/{id}")
    public ResponseDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.updateEmployee(id, employeeDTO);
        return new ResponseDTO("Employee updated successfully", employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseDTO deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseDTO("Employee deleted successfully", null);
    }

}
