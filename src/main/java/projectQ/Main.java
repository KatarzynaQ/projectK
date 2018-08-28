package projectQ;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

String path="C:\\workspace\\account.csv";
BankAccountParser i=new BankAccountParser();

        try {
            List<BankAccount>bList=new ArrayList<>();
            bList=i.readBankPayment(path);
            System.out.println(bList);
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }
}
