package skypro.employee.SpringEmployeeBook.services;

import skypro.employee.SpringEmployeeBook.repository.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MockConstants {
    public static final List<Employee> EMPLOYEES_FROM_DEP1 = List.of(
            new Employee("Тест1_тмя", "Тест1_фамилия", 1, 10),
            new Employee("Тест2_тмя", "Тест2_фамилия", 1, 30000)
    );
    public static final List<Employee> EMPLOYEES_FROM_DEP2 = List.of(
            new Employee("Тест3_тмя", "Тест3_фамилия", 2, 20),
            new Employee("Тест4_тмя", "Тест4_фамилия", 2, 40000)
    );
    public static final Map<Integer, List<Employee>> MAP = new HashMap<>(Map.of(1, EMPLOYEES_FROM_DEP1, 2, EMPLOYEES_FROM_DEP2));
    public static final int MAX = EMPLOYEES_FROM_DEP1.stream().mapToInt(Employee::getSalary).max().getAsInt();
    public static final int MIN = EMPLOYEES_FROM_DEP1.stream().mapToInt(Employee::getSalary).min().getAsInt();
    public static final int SUM = EMPLOYEES_FROM_DEP1.stream().mapToInt(Employee::getSalary).sum();
}
