package skypro.employee.SpringEmployeeBook.services;

import skypro.employee.SpringEmployeeBook.repository.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeServiceInterface {
    Map<Integer, List<Employee>> getAllEmployees();

    List<Employee> getEmployeesByDepartment(int ID);
}
