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
                companies.add(c);
                return companies;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return companies;
    }
}
