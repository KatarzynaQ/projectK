package projectQ;

import org.junit.Test;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.IOException;

import static org.junit.Assert.*;

public class NIPTest {

    @Test(expected = IOException.class)
    public void nipLenghtToShort() throws IOException {
        new NIP("123456789");
    }
    @Test(expected = IOException.class)
    public void nipLenghtToLong() throws IOException {
        new NIP("12345678901");
    }
    @Test(expected = IOException.class)
    public void nipDoNotContainsOnlyLetters() throws IOException {
        new NIP("123456789a");
    }
    @Test
           public void nipIsCorrect() throws IOException {
        NIP nip = new NIP ("1234563218");
        assertEquals("123-456-32-18", nip.getNip());
        new NIP("123456789");
    }

}