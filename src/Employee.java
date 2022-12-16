import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
/*
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
*/
class Employee {
    private String name;
    private Integer salary;
    private Date workStart;

    private static final java.text.SimpleDateFormat f = new java.text.SimpleDateFormat("dd.MM.yyyy");

    public Employee(String name, Integer salary, Date workStart) {
        this.name = name;
        this.salary = salary;
        this.workStart = workStart;
    }

    public String getName() {
        return name;
    }

    public Integer getSalary() {
        return salary;
    }

    public Date getWorkStart() {
        return workStart;
    }

    public int getYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(workStart);
        return calendar.get(Calendar.YEAR);
    }

    public static ArrayList<Employee> loadStaffFromFile(String path) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            List<String> list = Files.readAllLines(Paths.get(path));
            for (var str : list) {
                var item = str.split("\t");
                employees.add(new Employee(item[0], Integer.parseInt(item[1]), f.parse(item[2])));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        return employees;
    }

    @Override
    public String toString() {
        return String.format("<%s> — <%d> — <%s>", name, salary, f.format(workStart));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee another = (Employee) obj;
        return Objects.equals(name, another.getName()) &&
                Objects.equals(salary, another.getSalary()) &&
                Objects.equals(workStart, another.getWorkStart());
    }


}