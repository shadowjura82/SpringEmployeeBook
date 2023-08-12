package skypro.employee.SpringEmployeeBook.services;

import org.springframework.stereotype.Service;
import skypro.employee.SpringEmployeeBook.repository.Employee;

import java.util.List;
import java.util.Map;

@Service
public class DepartmentService implements DepartmentServiceInterface{
    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public List<Employee> getEmployeesByDepartment(int ID) {
        return employeeService.getEmployeesByDepartment(ID);
    }

    public int getSalarySum(int ID) {
        // Переделать на стримы !!!!!!!!!!!!
        List<Employee> emp = employeeService.getEmployeesByDepartment(ID);
        int sum = 0;
        for (Employee e : emp) sum += e.getSalary();
        return sum;
    }

    public int getSalaryMax(int ID) {
        // Переделать на стримы !!!!!!!!!!!!
        List<Employee> emp = employeeService.getEmployeesByDepartment(ID);
        int max = 0;
        for (Employee e : emp) if (e.getSalary() > max) max = e.getSalary();
        return max;
    }

    public int getSalaryMin(int ID) {
        // Переделать на стримы !!!!!!!!!!!!
        List<Employee> emp = employeeService.getEmployeesByDepartment(ID);
        int min = getSalaryMax(ID);
        for (Employee e : emp) if (e.getSalary() < min) min = e.getSalary();
        return min;
    }
}
