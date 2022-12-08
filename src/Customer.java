import java.util.ArrayList;
import java.util.Objects;

import java.util.Scanner;
/*
public class Main {
    public static void main(String[] args) {
        CustomerStorage customerStorage = new CustomerStorage();
        Scanner input = new Scanner(System.in);
        String command = "";
        while (!command.equals("exit")) {
            command = input.next();
            switch (command) {
                case ("add"):
                    customerStorage.addCustomer(input.next());
                    break;
                case ("list"):
                    customerStorage.listCutomrs();
                    break;
                case ("remove"):
                    customerStorage.removeCustomer(input.next());
                    break;
                case ("count"):
                    System.out.println(customerStorage.getCount());
                    break;
                case ("help"):
                    System.out.println("Команды могут быть следующими:\nadd - добавить клиента.\nlist - вывести список всех клиенто\nremove - удалить клиента.\ncount - подсчитать всех клиентов.\nhelp - выводит пример команды.");
                    break;
                default:
                    System.out.println("Неверная команда");
                    break;
            }
        }
    }
}
*/



public class Customer {
    //TODO реализуйте методы и поля класса Customer
    /*Добавить приватные неизменяемые поля  phone.
    Добавить один конструктор для всех этих полей.
    Написать методы getName, getSurname, getPhone, getEmail, возвращающие соответственно значения этих полей.
    Также добавить метод toString, возвращающий строку типа: "name - surname - email - phone"*/
    private String name, surname, email, phone;

    public Customer(String name, String surname, String email, String phone) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", name, surname, email, phone);
    }

}

class CustomerStorage {
    //TODO реализуйте методы и поля класса CustomerStorage
    private ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(String str) {
        var info = str.split(" ");
        if ((info.length != 4) || (!isCorrectEmail(info[2])) || (!isCorrectPhone(info[3])))
            throw new IllegalArgumentException();
        customers.add(new Customer(info[0], info[1], info[2], info[3]));
    }

    public Customer getCustomer(String str) {
        var info = str.split(" ");
        if (info.length != 2) throw new RuntimeException();
        for (var customer : customers) {
            if (Objects.equals(customer.getName(), info[0]) && Objects.equals(customer.getSurname(), info[1])) {
                return customer;
            }
        }
        return null;
    }

    public int getCount() {
        return customers.size();
    }

    public void listCutomrs() {
        for (var customer : customers) {
            System.out.println(customer.toString());
        }
    }

    public void removeCustomer(String str) {
        var info = str.split(" ");
        if (info.length != 2) throw new RuntimeException();
        for (var customer : customers) {
            if (Objects.equals(customer.getName(), info[0]) && Objects.equals(customer.getSurname(), info[1])) {
                customers.remove(customer);
            }
        }
    }

    public boolean isCorrectEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    public boolean isCorrectPhone(String phone) {
        return phone.matches("^\\+\\d+$");
    }


}