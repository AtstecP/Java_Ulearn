public class UnitTestS02 {

    @Test
    public void runTest() {
        /*
        TODO протестируйте вашу задачу из прошлого модуля,
         напишите не менее 5 различных тестов для вашего приложения
         */
    }
    @Test
    public void bank_fullTest() {
        Bank bank = new Bank();
        bank.setAccounts(10);
        Account account = new Account();
        bank.transfer("0","1", 100)
        bank.transfer("1","2", 100)
        bank.transfer("2","3", 100)
        bank.transfer("3","4", 100)
        bank.transfer("4","0", 100)
        for (int i = 0; i < 10; ++i){
            Assertions.assertEquals(account.getMoney(), bank.getBalance(Integer.toString(i)));
        }
        bank.getBalance()
        Assertions.assertEquals(account.getMoney() * 10, bank.getSumAllAccounts());

    }
    @Test
    public void getMoney_test() {
        Account account = new Account();
        Assertions.assertEquals(0, account.getMoney());
    }


    @Test
    public void setMoney_test() {
        var account = new Account();
        account.setMoney(2000);
        Assertions.assertEquals(2000, account.getMoney());
    }

    @Test
    public void getSumAllAccounts_test() {
        Bank bank = new Bank();
        bank.setAccounts(10);
        Assertions.assertEquals(account.getMoney() * 10, bank.getSumAllAccounts());
    }


    @Test
    public void getAccNumber_test() {
        Account account = new Account();
        account.setAccNumber("5");
        Assertions.assertEquals("5", account.getAccNumber());
    }

    @Test
    public void transfer_test() {
        Bank bank = new Bank();
        bank.setAccounts(10);
        Account account = new Account();
        bank.transfer("0", "8", 123);
        Assertions.assertEquals(account.getMoney() - 123, bank.getBalance("0"));
        Assertions.assertEquals(account.getMoney()  + 123, bank.getBalance("8"));
    }


}