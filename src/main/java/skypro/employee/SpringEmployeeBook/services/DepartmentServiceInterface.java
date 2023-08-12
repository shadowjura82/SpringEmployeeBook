package skypro.employee.SpringEmployeeBook.services;

import skypro.employee.SpringEmployeeBook.repository.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    Map<Integer, List<Employee>> getAllEmployees();

    List<Employee> getEmployeesByDepartment(int ID);

    int getSalarySum(int ID);

    int getSalaryMax(int ID);

    int getSalaryMin(int ID);
}
