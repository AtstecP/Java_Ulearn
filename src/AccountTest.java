import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AccountTest {

    @Test
    void getMoney() {
        Account account = new Account("1", 1000);
        assertEquals(account.getMoney(), 1000);
    }

    @Test
    void setMoney() {
        Account account = new Account("1", 1000);
        account.setMoney(2000);
        assertEquals(account.getMoney(), 2000);
    }

    @Test
    void getAccNumber() {
        Account account = new Account("1", 1000);
        assertEquals(account.getAccNumber(), "1");
    }

    @Test
    void getStatus() {
        Account account = new Account("1", 1000);
        assertEquals(account.getStatus(), true);

    }

    @Test
    void setStatus() {
        Account account = new Account("1", 1000);
        assertEquals(account.getStatus(), true);
        account.setStatus(false);
        assertEquals(account.getStatus(), false);
    }

    @Test
    void setAccNumber() {
        Account account = new Account("1", 1000);
        assertEquals(account.getAccNumber(), "1");
        account.setAccNumber("99");
        assertEquals(account.getAccNumber(), "99");
    }
}