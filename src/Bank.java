import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public int getCount(){
        return accounts.size();
    }
    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами. Если сумма транзакции > 50000,
     * то после совершения транзакции, она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка счетов (как – на ваше
     * усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        try {
            Account fromAccount = accounts.get(fromAccountNum);
            Account toAccount = accounts.get(toAccountNum);
            if (fromAccount.getMoney() < amount) return;
            if (fromAccount.getStatus() && toAccount.getStatus()) {
                if (amount > 50000) {
                    if (isFraud(fromAccountNum, toAccountNum, amount)) {
                        fromAccount.setStatus(false);
                        toAccount.setStatus(false);
                        return;
                    }
                }
                fromAccount.setMoney(fromAccount.getMoney() - amount);
                toAccount.setMoney(toAccount.getMoney() + amount);
            }
        }catch (Exception e) {
        throw new RuntimeException();
    }
    }


    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) {
        return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        //TODO реализуйте метод получения баланса со всех аккаунтов
        return accounts.values().stream()
                .mapToLong(Account::getMoney)
                .sum();
    }

    public void setAccounts(int count) {
        accounts.clear();
        java.util.stream.IntStream.range(0, count)
                .mapToObj(x -> new Account(Integer.toString(x), 1_000_000))
                .forEach(x -> accounts.put(x.getAccNumber(), x));
        //TODO метод, который создаёт <count> аккаунтов
    }
}

class Account {
    private long money;
    private String accNumber;
    private boolean status = true;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
}

class TransferRun implements Runnable {

    private static Bank bank; //поле банка
    private int count; //количество аккаутов
    private int operationsCount; //количество операций, которые нужно совершить

    public TransferRun(Bank bank, int count, int operationsCount) {
        TransferRun.bank = bank;
        this.count = count;
        this.operationsCount = operationsCount;
    }

    @Override
    public void run() {
        Random random = new Random();
        String fromAccount = Integer.toString(random.nextInt(bank.getCount()-1));
        String toAccount = Integer.toString(random.nextInt(bank.getCount()));
        bank.transfer(fromAccount, toAccount, bank.getBalance(fromAccount)/2);

        //TODO реализуйте здесь <operationsCount> случайных операций
    }
}