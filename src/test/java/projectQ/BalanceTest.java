package projectQ;

import org.junit.Test;
import projectQ.service.AccountCounter;
import projectQ.service.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BalanceTest {
    private List<BankAccount>account;

    private NIP myNIP;

    @Test
    public void accountBalanceTest(){
        account=new ArrayList<>();


        BankAccount b1=new BankAccount();
        b1.setOperationType(OperationType.IN);
        b1.setAmount(1000.0);
        BankAccount b2=new BankAccount();
        b2.setOperationType(OperationType.OUT);
        b2.setAmount(1000.0);
        BankAccount b3=new BankAccount();
        b3.setOperationType(OperationType.IN);
        b3.setAmount(1000.0);
        BankAccount b4=new BankAccount();
        b4.setOperationType(OperationType.OUT);
        b4.setAmount(1000.0);
        BankAccount b5=new BankAccount();
        b5.setOperationType(OperationType.IN);
        b5.setAmount(1000.0);
        account.add(b1);
        account.add(b2);
        account.add(b3);
        account.add(b4);
        account.add(b5);
        AccountCounter SUT=new AccountCounter(account);

        assertEquals(1000.0,SUT.accountBalance(),0.0000007);
    }
}
