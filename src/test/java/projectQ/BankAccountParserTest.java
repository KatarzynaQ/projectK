package projectQ;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BankAccountParserTest {

    @Test
    public void readBankPaymentTest() throws ParseException, IOException {

        BankAccount i = new BankAccount();

        i.setData(i.parsingDateFromString("01-09-2018"));
        i.setAmount(3.69);
        i.setNIP("5621807397");
        i.setOperationType(OperationType.IN);
        i.setTitleNumber("FS/1/2018");



        String path = "C:\\workspace\\account.csv";
        BankAccountParser j = new BankAccountParser();

        try {
            List <BankAccount> bList = new ArrayList <>();
            bList = j.readBankPayment(path);
            bList.get(0);
            System.out.println(bList);
            assertEquals(i.getAmount(),(bList.get(0).getAmount()));
            assertEquals(i.getData(),(bList.get(0)).getData());
            assertEquals(i.getNIP(),(bList.get(0)).getNIP());
            assertEquals(i.getTitleNumber(),(bList.get(0)).getTitleNumber());
        } catch (
                ParseException e) {
            e.printStackTrace();
        }


    }
}
