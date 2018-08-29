package projectQ;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BankAccountParserTest {

    @Test
    public void readBankPaymentTest() throws ParseException {

        BankAccount i = new BankAccount();

        i.setData(i.parsingDateFromString("01-09-2018"));
        i.setAmount(3.69);
        i.setNIP("5621807397");
        i.setOperationType(OperationType.IN);
        i.setTitleNumber("FS/1/2018");



        String path = "D:\\workspace\\projectK\\account.csv";
        BankAccountParser j = new BankAccountParser();

        try {
            List <BankAccount> bList = new ArrayList <>();
            bList = j.readBankPayment(path);
            bList.get(0);
            System.out.println(bList);
            Assert.assertEquals(i,bList.get(0));
        } catch (
                ParseException e) {
            e.printStackTrace();
        }

//        Assert.assertEquals(i,bList.get(0));
    }
}
