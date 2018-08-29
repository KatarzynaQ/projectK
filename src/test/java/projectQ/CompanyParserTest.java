package projectQ;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class CompanyParserTest {

    @Test
    public void CompanyParserTest() throws IOException {
        CompanyParser cp = new CompanyParser();
        Company company = new Company();
        company.setNip(new NIP("9532535663"));
        company.setName("ABC1");
        assertEquals(company, cp.readCompanies());
    }
}
