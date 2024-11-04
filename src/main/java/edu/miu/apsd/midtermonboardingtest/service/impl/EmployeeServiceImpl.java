package edu.miu.apsd.midtermonboardingtest.service.impl;

import edu.miu.apsd.midtermonboardingtest.model.Employee;
import edu.miu.apsd.midtermonboardingtest.respository.EmployeeRepository;
import edu.miu.apsd.midtermonboardingtest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return repository.findAllEmployeesSortedBySalaryAndLastName();
    }

    public Employee addNewEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void updateEmployee(long id, Employee employee) {
        repository.findById(id).ifPresent(emp -> {
            emp.setId(id);
            emp.setFirstName(employee.getFirstName());
            emp.setLastName(employee.getLastName());
            employeeRepository.save(emp);
        });
    }

    public void deleteEmployee(long id) {
        repository.deleteById(id);
    }


}
