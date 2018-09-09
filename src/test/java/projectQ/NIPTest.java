package projectQ;

import org.junit.Test;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NIPTest {
    @Test(expected = InvalidNipNumber.class)
    public void nipLengthToShort() throws InvalidNipNumber {

            new NIP("123456789");

    }

    @org.junit.Test(expected = InvalidNipNumber.class)
    public void nipLengthToLong() throws IOException, InvalidNipNumber {

            new NIP("12345678901");


    }



    @Test(expected = InvalidNipNumber.class)
    public void nipDoNotContainsOnlyLetters() throws InvalidNipNumber {

            new NIP("123456789a");

    }



    @Test

    public void nipIsCorrect() {
        NIP nip = null;
        try {
            nip = new NIP("123 456 32 18");
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        assertEquals("123-456-32-18", nip.getNip());
    }

//    @Test(expected = IOException.class)
//    public void nipLenghtToShort() throws IOException {
//        new NIP("123456789");
//    }
//    @Test(expected = IOException.class)
//    public void nipLenghtToLong() throws IOException {
//        new NIP("12345678901");
//    }
//    @Test(expected = IOException.class)
//    public void nipDoNotContainsOnlyLetters() throws IOException {
//        new NIP("123456789a");
//    }
//    @Test
//           public void nipIsCorrect() throws IOException {
//        NIP nip = new NIP ("1234563218");
//        assertEquals("123-456-32-18", nip.getNip());
//        new NIP("123456789");
//    }

}