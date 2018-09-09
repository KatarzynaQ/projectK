package projectQ;

import org.junit.Test;

import projectQ.service.Model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertEquals;

public class MyCommitmentsTest {
    private List<Invoice> invoiceTestList;
    private List<Company> companiesTest;
    private List<BankAccount> bankAccountTestList;
    private NIP myNIP;
    private List<Invoice> SUT;
    private Model model;

    @Test
    public void unPaidInvoicesTest() {

        /*
         *invoiceTestList contains 3 invoices when we are buyers (called "weBuy")
         * and 3 invoices when whe are sellers (called "weSell")
         * two of them have the same NIP and one is different (to test how is sum of commitments added)
         *
         * */
        invoiceTestList = new ArrayList<>();
        bankAccountTestList = new ArrayList<>();
        try {
            myNIP = new NIP("9532535663");
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
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

        weBuy1.setTitleNumber("weBuy1");
        weBuy2.setTitleNumber("weBuy2");
        weBuy3.setTitleNumber("weBuy3");

        weSell1.setTitleNumber("weSell1");
        weSell2.setTitleNumber("weSell2");
        weSell3.setTitleNumber("weSell3");
        try {
            weBuy1.setSeller(new NIP("5621807397"));
            weBuy1.setBuyer(myNIP);
            weBuy2.setSeller(new NIP("5580004619"));
            weBuy2.setBuyer(myNIP);
            weBuy3.setSeller(new NIP("5621807397"));
            weBuy3.setBuyer(myNIP);

            weSell1.setBuyer(new NIP("5842741225"));
            weSell1.setSeller(myNIP);
            weSell2.setBuyer(new NIP("5580004619"));
            weSell2.setSeller(myNIP);
            weSell3.setBuyer(new NIP("5842741225"));
            weSell3.setSeller(myNIP);
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }

        invoiceTestList.add(weBuy1);
        invoiceTestList.add(weSell2);
        invoiceTestList.add(weSell1);
        invoiceTestList.add(weBuy2);
        invoiceTestList.add(weBuy3);
        invoiceTestList.add(weSell3);

        BankAccount ba1 = new BankAccount();
        BankAccount ba2 = new BankAccount();
//        BankAccount ba3 = new BankAccount();
//        BankAccount ba4 = new BankAccount();

        ba1.setAmount(100.0);
        ba1.setOperationType(OperationType.OUT);
        ba1.setTitleNumber("weBuy1");

        ba2.setAmount(50.0);
        ba2.setOperationType(OperationType.IN);
        ba2.setTitleNumber("weSell2");

        try {
            ba1.setNIP(new NIP("5621807397"));
            ba2.setNIP(new NIP("5842741225"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        bankAccountTestList.add(ba1);
        bankAccountTestList.add(ba2);


        SUT = new ArrayList<>();
        SUT.add(weBuy2);
        SUT.add(weBuy3);
        SUT.add(weSell1);
        SUT.add(weSell3);
        Collections.sort(SUT, Collections.reverseOrder());
        model = new Model(invoiceTestList, companiesTest, bankAccountTestList, myNIP);
        List<BankAccount> emptyPayments = new ArrayList<>();
        List<Invoice> result1 = model.onlyUnPaid(invoiceTestList, bankAccountTestList);
        List<Invoice> result2 = model.onlyUnPaid(invoiceTestList, emptyPayments);
        Collections.sort(invoiceTestList,Collections.reverseOrder());
        assertEquals(SUT, result1);
        assertEquals(invoiceTestList, result2);
    }

    @Test
    public void myCommitmentsTest() {
        invoiceTestList = new ArrayList<>();
        bankAccountTestList = new ArrayList<>();
        try {
            myNIP = new NIP("9532535663");
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
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

        weBuy1.setTitleNumber("weBuy1");
        weBuy2.setTitleNumber("weBuy2");
        weBuy3.setTitleNumber("weBuy3");

        weSell1.setTitleNumber("weSell1");
        weSell2.setTitleNumber("weSell2");
        weSell3.setTitleNumber("weSell3");
        try {
            weBuy1.setSeller(new NIP("5621807397"));
            weBuy1.setBuyer(myNIP);
            weBuy2.setSeller(new NIP("5580004619"));
            weBuy2.setBuyer(myNIP);
            weBuy3.setSeller(new NIP("5621807397"));
            weBuy3.setBuyer(myNIP);

            weSell1.setBuyer(new NIP("5842741225"));
            weSell1.setSeller(myNIP);
            weSell2.setBuyer(new NIP("5580004619"));
            weSell2.setSeller(myNIP);
            weSell3.setBuyer(new NIP("5842741225"));
            weSell3.setSeller(myNIP);
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }

        invoiceTestList.add(weBuy1);
        invoiceTestList.add(weSell2);
        invoiceTestList.add(weSell1);
        invoiceTestList.add(weBuy2);
        invoiceTestList.add(weBuy3);
        invoiceTestList.add(weSell3);

        BankAccount ba1 = new BankAccount();
        BankAccount ba2 = new BankAccount();
//        BankAccount ba3 = new BankAccount();
//        BankAccount ba4 = new BankAccount();

        ba1.setAmount(100.0);
        ba1.setOperationType(OperationType.OUT);
        ba1.setTitleNumber("weBuy1");

        ba2.setAmount(50.0);
        ba2.setOperationType(OperationType.IN);
        ba2.setTitleNumber("weSell2");

        try {
            ba1.setNIP(new NIP("5621807397"));
            ba2.setNIP(new NIP("5842741225"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        bankAccountTestList.add(ba1);
        bankAccountTestList.add(ba2);


        Map<NIP,Double> comTest=new HashMap<>();
        comTest.put(weBuy2.getSeller(),weBuy2.getNetto());
        comTest.put(weBuy3.getSeller(),weBuy3.getNetto());

        model = new Model(invoiceTestList, companiesTest, bankAccountTestList, myNIP);
        assertEquals(comTest,model.myCommitments());
    }
}
