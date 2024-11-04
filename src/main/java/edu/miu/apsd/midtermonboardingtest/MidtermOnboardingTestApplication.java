package edu.miu.apsd.midtermonboardingtest;

import edu.miu.apsd.midtermonboardingtest.model.Employee;
import edu.miu.apsd.midtermonboardingtest.respository.EmployeeRepository;
import edu.miu.apsd.midtermonboardingtest.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class MidtermOnboardingTestApplication {

	private final EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(MidtermOnboardingTestApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
		return args -> {
			employeeRepository.deleteAll();

			Employee john = new Employee(null, "John", "Doe", 50_000.0);
			employeeService.addNewEmployee(john);

			Employee jane = new Employee(null, "Jane", "Dona", 50_000);
			employeeService.addNewEmployee(jane);

			Employee alice = new Employee(null, "Alice", "Smith", 60_000);
			employeeService.addNewEmployee(alice);

			Employee bob = new Employee(null, "Bob", "Brown", 45_000);
			employeeService.addNewEmployee(bob);

			System.out.println(employeeService.getAllEmployees());
		};
	}
}
