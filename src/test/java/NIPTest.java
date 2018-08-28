import org.junit.Before;
import org.junit.Test;
import projectQ.NIP;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class NIPTest {

    private String toCheckNumber;
    private String correctNip;
    private NIP nipTesting;

    @Before
    public void initialize() {
        toCheckNumber = "953-253kj56-63";
        correctNip = "953-253-56-63";
        nipTesting = new NIP();
    }


    @Test
    public void NIPOnlyIntegersFromStringTest() {
        List<Integer> result = new ArrayList<Integer>();
        result.add(9);
        result.add(5);
        result.add(3);
        result.add(2);
        result.add(5);
        result.add(3);
        result.add(5);
        result.add(6);
        result.add(6);
        result.add(3);
        System.out.println(result);

        assertEquals(result, NIP.onlyIntegersFromString(toCheckNumber));
    }

}
