import java.util.Scanner;

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
                    System.out.println("""
                            Команды могут быть следующими:
                                                        
                            add - добавить клиента.
                                                        
                            list - вывести список всех клиентов.
                                                        
                            remove - удалить клиента.
                                                        
                            count - подсчитать всех клиентов.
                                                        
                            help - выводит пример команды.""");
                    break;
                default:
                    System.out.println("Неверная команда");
                    break;
            }
        }
    }
}



