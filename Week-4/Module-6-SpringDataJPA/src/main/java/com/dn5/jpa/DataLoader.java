package com.dn5.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        Department engineering = new Department("Engineering", "Building A");
        Department sales = new Department("Sales", "Building B");
        Department hr = new Department("HR", "Building C");

        departmentRepository.save(engineering);
        departmentRepository.save(sales);
        departmentRepository.save(hr);

        Employee emp1 = new Employee("John", "Doe", "john@company.com", 75000);
        emp1.setDepartment(engineering);

        Employee emp2 = new Employee("Alice", "Smith", "alice@company.com", 82000);
        emp2.setDepartment(engineering);

        Employee emp3 = new Employee("Bob", "Wilson", "bob@company.com", 65000);
        emp3.setDepartment(sales);

        Employee emp4 = new Employee("Diana", "Brown", "diana@company.com", 70000);
        emp4.setDepartment(hr);

        Employee emp5 = new Employee("Charlie", "Davis", "charlie@company.com", 90000);
        emp5.setDepartment(engineering);

        employeeRepository.save(emp1);
        employeeRepository.save(emp2);
        employeeRepository.save(emp3);
        employeeRepository.save(emp4);
        employeeRepository.save(emp5);

        System.out.println("=== All Employees ===");
        employeeRepository.findAll().forEach(System.out::println);

        System.out.println("=== Employees with salary > 70000 ===");
        employeeRepository.findBySalaryGreaterThan(70000).forEach(System.out::println);

        System.out.println("=== Engineering Department ===");
        employeeRepository.findByDepartmentName("Engineering").forEach(System.out::println);

        System.out.println("=== Salary Range 65000-80000 ===");
        employeeRepository.findBySalaryRange(65000, 80000).forEach(System.out::println);
    }
}
