package skypro.employee.SpringEmployeeBook.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import skypro.employee.SpringEmployeeBook.exceptions.DepartmentNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static skypro.employee.SpringEmployeeBook.services.MockConstants.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceTest {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService departmentService;

    @Test
    void getAllEmployees() {
        when(employeeService.getAllEmployees()).thenReturn(MAP);
        assertEquals(MAP, departmentService.getAllEmployees());
    }

    @Test
//    Как избавиться от дублирующегося кода (@BeforeEach не помогает)
    void getEmployeesByDepartment() {
        when(employeeService.getEmployeesByDepartment(1)).thenReturn(EMPLOYEES_FROM_DEP1);
        when(employeeService.getEmployeesByDepartment(3)).thenThrow(DepartmentNotFoundException.class);
        assertIterableEquals(EMPLOYEES_FROM_DEP1, departmentService.getEmployeesByDepartment(1));
        assertThrows(DepartmentNotFoundException.class, () -> departmentService.getEmployeesByDepartment(3));
    }

    @Test
//    Как избавиться от дублирующегося кода (@BeforeEach не помогает)
    void getSalarySum() {
        when(employeeService.getEmployeesByDepartment(1)).thenReturn(EMPLOYEES_FROM_DEP1);
        when(employeeService.getEmployeesByDepartment(3)).thenThrow(DepartmentNotFoundException.class);
        assertEquals(SUM, departmentService.getSalarySum(1));
        assertThrows(DepartmentNotFoundException.class, () -> departmentService.getSalarySum(3));
    }

    @Test
//    Как избавиться от дублирующегося кода (@BeforeEach не помогает)
    void getSalaryMax() {
        when(employeeService.getEmployeesByDepartment(1)).thenReturn(EMPLOYEES_FROM_DEP1);
        when(employeeService.getEmployeesByDepartment(3)).thenThrow(DepartmentNotFoundException.class);
        assertEquals(MAX, departmentService.getSalaryMax(1));
        assertThrows(DepartmentNotFoundException.class, () -> departmentService.getSalaryMax(3));
    }

    @Test
//    Как избавиться от дублирующегося кода (@BeforeEach не помогает)
    void getSalaryMin() {
        when(employeeService.getEmployeesByDepartment(1)).thenReturn(EMPLOYEES_FROM_DEP1);
        when(employeeService.getEmployeesByDepartment(3)).thenThrow(DepartmentNotFoundException.class);
        assertEquals(MIN, departmentService.getSalaryMin(1));
        assertThrows(DepartmentNotFoundException.class, () -> departmentService.getSalaryMin(3));
    }
}