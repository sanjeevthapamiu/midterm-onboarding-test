package edu.miu.apsd.midtermonboardingtest.respository;

import edu.miu.apsd.midtermonboardingtest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e ORDER BY e.salary asc, e.lastName desc")
    List<Employee> findAllEmployeesSortedBySalaryAndLastName();

    // Same as JPQL above
    List<Employee> findAllByOrderBySalaryAscLastNameDesc();

}
