package skypro.employee.SpringEmployeeBook.controller;

import org.springframework.web.bind.annotation.*;
import skypro.employee.SpringEmployeeBook.repository.Employee;
import skypro.employee.SpringEmployeeBook.services.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }

    @GetMapping(path = "{id}/employees")
    public List<Employee> getEmployeesByDepartment(@PathVariable(name = "id") int ID) {
        return departmentService.getEmployeesByDepartment(ID);
    }

    @GetMapping(path = "{id}/salary/sum")
    public int getSalarySum(@PathVariable(name = "id") int ID) {
        return departmentService.getSalarySum(ID);
    }

    @GetMapping(path = "{id}/salary/max")
    public int getSalaryMax(@PathVariable(name = "id") int ID) {
        return departmentService.getSalaryMax(ID);
    }

    @GetMapping(path = "{id}/salary/min")
    public int getSalaryMin(@PathVariable(name = "id") int ID) {
        return departmentService.getSalaryMin(ID);
    }
}