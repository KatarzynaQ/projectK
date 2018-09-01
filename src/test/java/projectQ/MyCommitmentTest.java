package projectQ;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

public class MyCommitmentTest {

    @Test
    public void sortOnlyCommitmentTest(){
        UserInterface ui=new UserInterface();


        try {
            Method onlyCommitment=Model.class.getDeclaredMethod("onlyCommitments");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
