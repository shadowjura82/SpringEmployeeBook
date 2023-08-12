package skypro.employee.SpringEmployeeBook.exceptions;

public class DepartmentNotFoundException extends RuntimeException{
    public DepartmentNotFoundException(String message) {
        super(message);
    }
}
