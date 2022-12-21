//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class UnitTestS02 {
//
//    @Test
//    public void runTest(){
//        /*
//        TODO протестируйте вашу задачу из прошлого модуля,
//         напишите не менее 5 различных тестов для вашего приложения
//         */
//    }
//
//    @Test
//    void getCount() {
//        Bank bank = new Bank();
//        bank.setAccounts(10);
//        Assertions.assertEquals(bank.getCount(),10);
//    }
//
//
//    @Test
//    void getBalance() {
//        Bank bank = new Bank();
//        bank.setAccounts(10);
//        Assertions.assertEquals(bank.getBalance("1"),1_000_000);
//    }
//
//    @Test
//    void getSumAllAccounts() {
//        Bank bank = new Bank();
//        bank.setAccounts(10);
//        bank.
//        Assertions.assertEquals(bank.getSumAllAccounts(),1_000_000*10);
//    }
//
//    @Test
//    void getMoney() {
//        Account account = new Account("1", 1000);
//        Assertions.assertEquals(account.getMoney(), 1000);
//    }
//
//    @Test
//    void setMoney() {
//        Account account = new Account("1", 1000);
//        account.setMoney(2000);
//        Assertions.assertEquals(account.getMoney(), 2000);
//    }
//
//    @Test
//    void getAccNumber() {
//        Account account = new Account("1", 1000);
//        Assertions.assertEquals(account.getAccNumber(), "1");
//    }
//
//    @Test
//    void getStatus() {
//        Account account = new Account("1", 1000);
//        Assertions.assertEquals(account.getStatus(), true);
//
//    }
//
//    @Test
//    void setStatus() {
//        Account account = new Account("1", 1000);
//        Assertions.assertEquals(account.getStatus(), true);
//        account.setStatus(false);
//        Assertions.assertEquals(account.getStatus(), false);
//    }
//
//    @Test
//    void setAccNumber() {
//        Account account = new Account("1", 1000);
//        Assertions.assertEquals(account.getAccNumber(), "1");
//        account.setAccNumber("99");
//        Assertions.assertEquals(account.getAccNumber(), "99");
//    }
//}