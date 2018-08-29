package projectQ;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountParserTest {

    @Test
    public void readBankPaymentTest() {

        BankAccount i = new BankAccount();

        i.setData(i);
        i.setAmount();



        String path = "C:\\workspace\\account.csv";
        BankAccountParser i = new BankAccountParser();

        try {
            List <BankAccount> bList = new ArrayList <>();
            bList = i.readBankPayment(path);
            System.out.println(bList);
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
    }
}
