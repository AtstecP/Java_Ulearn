import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TODO напишите консольное приложение для взаимодействия с телефонной книгой
        PhoneBook book = new PhoneBook();
        Scanner in = new Scanner(System.in);
        String command;
        while (true) {
            System.out.println("Введите номер, имя или команду:");
            command = in.next();
            if (command.equals("LIST")) {
                book.getAllContacts().forEach(System.out::println);
            } else if (command.matches("^\\d+$")) {
                if (book.getNameByPhone(command).equals("")) {
                    System.out.println("Такого номера нет в телефонной книге.\nВведите имя абонента для номера ");
                    book.addContact(command, in.next());
                    if (!book.getNameByPhone(command).equals(""))
                        System.out.println("Контакт сохранен!");
                    else
                        System.out.println("Контакт НЕ сохранен, неверные данные, начни сначала!");
                } else
                    System.out.println(book.getNameByPhone(command));
            } else {
                if (book.getPhonesByName(command) == null) {
                    System.out.println("Такого имени в телефонной книге нет.\nВведите номер телефона для абонента " + command);
                    book.addContact( in.next(), command);
                    if (book.getPhonesByName(command) != null)
                        System.out.println("Контакт сохранен!");
                    else
                        System.out.println("Контакт НЕ сохранен, неверные данные, начни сначала!");
                } else
                    book.getPhonesByName(command).forEach(System.out::println);
            }

        }

    }
}


