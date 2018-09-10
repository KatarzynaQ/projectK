package projectQ;

import org.junit.Test;
import projectQ.service.InvoicesCounter;
import projectQ.service.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MyProvidersTest {

    private NIP myNip;
    private List<Invoice>invoiceTestList;

    @Test
    public void topFiveProviders() throws InvalidNipNumber {
        Invoice weBuy1 = new Invoice();
        Invoice weBuy2 = new Invoice();
        Invoice weBuy3 = new Invoice();

        Invoice weSell1 = new Invoice();
        Invoice weSell2 = new Invoice();
        Invoice weSell3 = new Invoice();

        weBuy1.setNetto(100.0);
        weBuy2.setNetto(50.0);
        weBuy3.setNetto(200.0);

        weSell1.setNetto(100.0);
        weSell2.setNetto(50.0);
        weSell3.setNetto(200.0);
        myNip = new NIP("9532535663");
        try {
            weBuy1.setSeller(new NIP("5621807397"));
            weBuy1.setBuyer(myNip);
            weBuy2.setSeller(new NIP("5580004619"));
            weBuy2.setBuyer(myNip);
            weBuy3.setSeller(new NIP("5621807397"));
            weBuy3.setBuyer(myNip);

            weSell1.setBuyer(new NIP("5842741225"));
            weSell1.setSeller(myNip);
            weSell2.setBuyer(new NIP("5580004619"));
            weSell2.setSeller(myNip);
            weSell3.setBuyer(new NIP("5842741225"));
            weSell3.setSeller(myNip);
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        invoiceTestList=new ArrayList<>();
        invoiceTestList.add(weBuy1);
        invoiceTestList.add(weSell2);
        invoiceTestList.add(weSell1);
        invoiceTestList.add(weBuy2);
        invoiceTestList.add(weBuy3);
        invoiceTestList.add(weSell3);
        List<Invoice>SUT=new ArrayList<>();
        SUT.add(weBuy3);
        SUT.add(weBuy1);
        SUT.add(weBuy2);

        InvoicesCounter ic = new InvoicesCounter(invoiceTestList,myNip);
        Map<NIP,Double>mapTest = ic.companiesToReturn();

        assertEquals(3,mapTest .size());
        //assertEquals(SUT,);
    }
}
