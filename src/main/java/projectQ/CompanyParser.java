package projectQ;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CompanyParser {

    public List<Company> readCompanies(String path) {
        FileReader fr = null;
        BufferedReader br = null;
        String line;
        List<Company> companies = new ArrayList<>();

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                Company c = new Company();
                String[] data = line.split(";");
                c.setName(data[0]);
                c.setNip(data[1]);
                if (!data[2].equals("")) {
                    b.setAmount(Double.valueOf(data[2]));
                    b.setOperationType(OperationType.OUT);
                } else {
                    b.setAmount(Double.valueOf(data[3]));
                    b.setOperationType(OperationType.IN);
                }
                DateFormat df = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
                Date dt = df.parse(data[4]);
                b.setData(dt);
                bankAccounts.add(b);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return bankAccounts;
    }
}
}
