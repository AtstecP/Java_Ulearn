import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static ArrayList<Employee> staff;
    public static void main(String[] args, String path) {
        staff = Employee.loadStaffFromFile(path);
    }

    public static Employee findEmployeeWithHighestSalary(int year) {
        try{
            return staff.stream().filter(employee -> employee.getYear() == year).max(Comparator.comparing(Employee::getSalary)).orElseThrow();

        }catch (Exception e){
            throw new IllegalArgumentException();
        }
    }

    public static ArrayList<Employee> sortEmployee(String column) {
        return staff.stream().sorted(getComparator(column)).collect(Collectors.toCollection(ArrayList::new));
    }

    private static Comparator<Employee> getComparator(String data) {
        if (data == null)
            throw new IllegalArgumentException();
        switch (data) {
            case "name":
                return Comparator.comparing(Employee::getName);
            case "salary":
                return Comparator.comparing(Employee::getSalary);
            case "date":
                return Comparator.comparing(Employee::getWorkStart);
            default:
                throw new IllegalArgumentException();
        }
    }
}

