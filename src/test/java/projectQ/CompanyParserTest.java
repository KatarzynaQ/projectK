package projectQ;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CompanyParserTest {

    @Test
    public void CompanyParserTest() throws IOException {
        String path = "C:\\workspace\\projectQ\\companys.csv";
        CompanyParser cp=new CompanyParser();
        Company company = new Company();
        company.setNip("9532535663");
        company.setName("ABC1");
        List<Company> list=new ArrayList<>();
        list=cp.readCompanies(path);
        assertEquals(company.getName(),(list.get(0)).getName());

    }
}
