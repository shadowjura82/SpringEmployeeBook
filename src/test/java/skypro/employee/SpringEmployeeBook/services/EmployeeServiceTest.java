package skypro.employee.SpringEmployeeBook.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import skypro.employee.SpringEmployeeBook.exceptions.DepartmentNotFoundException;
import skypro.employee.SpringEmployeeBook.repository.Employee;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {
    EmployeeService employeeService = new EmployeeService();

    @Test
    void getAllEmployees() {
        assertEquals(51, employeeService.getAllEmployees().size());
        assertFalse(employeeService.getAllEmployees().containsValue(null));
        for (List<Employee> e : employeeService.getAllEmployees().values())
            e.forEach(Assertions::assertNotNull);
    }

    @Test
    void getEmployeesByDepartment() {
        List<Employee> tst = new ArrayList<>(List.of(
                new Employee("Тест1_тмя", "Тест1_фамилия", -1, 30000),
                new Employee("Тест2_тмя", "Тест2_фамилия", -1, 30000),
                new Employee("Тест3_тмя", "Тест3_фамилия", -1, 30000)
        ));
        assertIterableEquals(tst,employeeService.getEmployeesByDepartment(-1));
    }

    @Test
    void getEmployeesByDepartmentThrowsException() {
        assertThrows(DepartmentNotFoundException.class,() -> employeeService.getEmployeesByDepartment(-2));
    }
}