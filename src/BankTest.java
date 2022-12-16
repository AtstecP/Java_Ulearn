import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @org.junit.jupiter.api.Test
    void getCount() {
        Bank bank = new Bank();
        bank.setAccounts(10);
        assertEquals(bank.getCount(),10);
    }

    @org.junit.jupiter.api.Test
    void transfer() {
        Bank bank = new Bank();
        bank.setAccounts(10);
        bank.transfer("1","2",50000);

    }
    @org.junit.jupiter.api.Test
    void getBalance() {
        Bank bank = new Bank();
        bank.setAccounts(10);
        assertEquals(bank.getBalance("1"),1_000_000);
    }

    @org.junit.jupiter.api.Test
    void getSumAllAccounts() {
        Bank bank = new Bank();
        bank.setAccounts(10);
        assertEquals(bank.getSumAllAccounts(),1_000_000*10);
    }

}