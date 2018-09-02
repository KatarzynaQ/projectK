package projectQ;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MyProvidersTest {


    @Test
    public void topFiveProviders() throws InvalidNipNumber {
        UserInterface ui = new UserInterface();
        Model model = ui.modelBuilder();
        NIP nip = new NIP("5580004619");
        List<NIP> listOfTopFiveNips = model.topFiveProviders();

        assertEquals(5, listOfTopFiveNips.size());
        assertEquals(nip.toString(), listOfTopFiveNips.get(0).toString());
    }
}
