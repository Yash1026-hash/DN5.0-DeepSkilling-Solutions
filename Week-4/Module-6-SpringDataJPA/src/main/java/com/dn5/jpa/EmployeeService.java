package com.dn5.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existing = getEmployeeById(id);
        existing.setFirstName(updatedEmployee.getFirstName());
        existing.setLastName(updatedEmployee.getLastName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setSalary(updatedEmployee.getSalary());
        return employeeRepository.save(existing);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getEmployeesBySalaryGreaterThan(double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    public List<Employee> getEmployeesByDepartment(String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }
}
