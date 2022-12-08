import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

//public class Main {
//    public static void main(String[] args) {
//        //TODO напишите консольное приложение для взаимодействия с телефонной книгой
//        PhoneBook book = new PhoneBook();
//        Scanner in = new Scanner(System.in);
//        String command;
//        while (true) {
//            System.out.println("Введите номер, имя или команду:");
//            command = in.next();
//            if (command.equals("LIST")) {
//                book.getAllContacts().forEach(System.out::println);
//            } else if (command.matches("^\\d+$")) {
//                if (book.getNameByPhone(command).equals("")) {
//                    System.out.println("Такого номера нет в телефонной книге.\nВведите имя абонента для номера ");
//                    book.addContact(command, in.next());
//                    if (!book.getNameByPhone(command).equals(""))
//                        System.out.println("Контакт сохранен!");
//                    else
//                        System.out.println("Контакт НЕ сохранен, неверные данные, начни сначала!");
//                } else
//                    System.out.println(book.getNameByPhone(command));
//            } else {
//                if (book.getPhonesByName(command) == null) {
//                    System.out.println("Такого имени в телефонной книге нет.\nВведите номер телефона для абонента " + command);
//                    book.addContact( in.next(), command);
//                    if (book.getPhonesByName(command) != null)
//                        System.out.println("Контакт сохранен!");
//                    else
//                        System.out.println("Контакт НЕ сохранен, неверные данные, начни сначала!");
//                } else
//                    book.getPhonesByName(command).forEach(System.out::println);
//            }
//
//        }
//
//    }
//}
    
class PhoneBook {
    Map<String, String> book = new HashMap<>();

    public void addContact(String phone, String name) {
        //TODO проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (isCorrect(name, phone)) {
            book.put(phone, name);
        }
    }

    public String getNameByPhone(String phone) {
        //TODO формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        if (book.containsKey(phone)) {
            return book.get(phone);
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        //TODO по имени вернуть список номеров
        if (book.containsValue(name)) {
            Set<String> set = new HashSet<>();
            for (var key : book.keySet()) {
                if (book.get(key).equals(name)) {
                    set.add(key);
                }

            }
            return set;
        }
        //System.out.println("no");
        return null;
    }

    public StringBuilder getNumbersToString(Set<String> numbers) {
        //TODO вернуть номера в формате строки <номер>, <номер>.
        StringBuilder str = new StringBuilder();
        for (var number : numbers) {
            str.append(number + ", ");
        }
        return new StringBuilder(str.substring(0, str.length() - 2));
    }

    public Set<String> getAllContacts() {
        //TODO вернуть все контакты в формате <имя> — <номер>, <номер> и тд
        Set<String> set = new HashSet<>();
        for (var name : book.values()) {
            set.add(name + " - " + getNumbersToString(getPhonesByName(name)));
        }
        return set;
    }

    public boolean checkContacts(String name) {
        //TODO проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (book.containsValue(name)) {
            return true;
        }
        return false;
    }

    public boolean isCorrect(String name, String phone) {
        //TODO проверьте корректность номера
        // Pattern number_pattern = Pattern.compile("^\\d+$");
        if (phone.matches("^\\d+$") && (name.matches("^\\p{L}+$"))) {
            return true;
        }
        return false;
    }
}
