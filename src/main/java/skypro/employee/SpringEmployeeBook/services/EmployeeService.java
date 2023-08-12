package skypro.employee.SpringEmployeeBook.services;

import org.springframework.stereotype.Service;
import skypro.employee.SpringEmployeeBook.exceptions.DepartmentNotFoundException;
import skypro.employee.SpringEmployeeBook.repository.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private Map<Integer, List<Employee>> employees = new HashMap<>();

    public EmployeeService() {
        //Почему нельзя использовать i
        String[] FIRST_NAMES = {"Петр", "Василий", "Николай", "Александр", "Тихон", "Сергей", "Владимир", "Игорь", "Данил", "Илья"};
        String[] LAST_NAMES = {"Иванов", "Александров", "Таранов", "Прудняков", "Заречный", "Трофимов", "Пустовойт", "Астахов", "Калиниченко", "Конаненко"};
        Random x = new Random();
        for (int i = 0; i < 50; i++) {
            int finali = i;
            this.employees.put(i, Stream.generate(() -> new Employee(FIRST_NAMES[x.nextInt(10)], LAST_NAMES[x.nextInt(10)], finali, x.nextInt(100000)))
                    .limit(50)
                    .collect(Collectors.toList()));
        }

        //Добавление тестового отдела
        List<Employee> tst = new ArrayList<>(List.of(
                new Employee("Тест1_тмя", "Тест1_фамилия", -1, 30000),
                new Employee("Тест2_тмя", "Тест2_фамилия", -1, 30000),
                new Employee("Тест3_тмя", "Тест3_фамилия", -1, 30000)
        ));
        employees.put(-1, tst);
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        return employees;
    }

    public List<Employee> getEmployeesByDepartment(int ID) {
        if (!employees.containsKey(ID))
            throw new DepartmentNotFoundException("Введенный департамент не существует. Введите корректный департамент");
        return employees.get(ID);
    }
}