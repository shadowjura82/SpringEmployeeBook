package skypro.employee.SpringEmployeeBook.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsController {
    @ExceptionHandler(DepartmentNotFoundException.class)
    public void MyDepartmentNotFoundException(Exception e) {
        System.out.println(e.getMessage());
    }
}