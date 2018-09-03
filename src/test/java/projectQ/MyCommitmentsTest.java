package projectQ;

import org.junit.Test;

import java.lang.reflect.Method;

public class MyCommitmentsTest {
    @Test
    public void unPaidInvoicesTest() {
        UserInterface ui=new UserInterface();
        Model model=ui.modelBuilder();
        model.myCommitments();
    }
}
