package projectQ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BankAccountParser {

    public List<BankAccount> readBankPayment(String path) throws ParseException {
        BufferedReader br = null;
        FileReader fr = null;
        List<BankAccount> bankAccounts = new ArrayList<>();

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line;
            boolean firstLine=true;
            while ((line = br.readLine()) != null) {
                if(firstLine){
                    firstLine=false;
                    continue;
                }
                BankAccount b = new BankAccount();
                String[] data = line.split(";");
                b.setTitleNumber(data[0]);
                b.setNIP(new NIP(data[1]));
                if (!data[2].equals("")) {
                    b.setAmount(Double.valueOf(data[2]));
                    b.setOperationType(OperationType.OUT);
                } else {
                    b.setAmount(Double.valueOf(data[3]));
                    b.setOperationType(OperationType.IN);
                }
                b.setData(b.parsingDateFromString(data[4]));
                bankAccounts.add(b);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankAccounts;
    }
}
