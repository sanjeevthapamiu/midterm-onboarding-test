package edu.miu.apsd.midtermonboardingtest.service;


import edu.miu.apsd.midtermonboardingtest.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();
    Employee addNewEmployee(Employee employee);
    void updateEmployee(long id, Employee employee);
    void deleteEmployee(long id);

}
