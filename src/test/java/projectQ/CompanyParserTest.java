package projectQ;

import org.junit.Test;

import java.io.IOException;

public class CompanyParserTest {

    @Test
    public void CompanyParserTest() throws IOException {
        Company company = new Company();
        company.setNip(new NIP("9532535663"));
        company.setName("ABC1");
    }
}
