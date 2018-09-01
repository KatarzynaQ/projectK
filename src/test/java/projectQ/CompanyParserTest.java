package projectQ;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompanyParserTest {

    @Test
    public void CompanyParserTest() throws IOException {
        String path = "C:\\workspace\\companys.csv";
        CompanyParser cp=new CompanyParser();
        Company company = new Company();
        try {
            company.setNip(new NIP("9532535663"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        company.setName("ABC1");
        List<Company> list=new ArrayList<>();
        list=cp.readCompanies(path);
        assertEquals(company.getName(),(list.get(0)).getName());

    }
}
