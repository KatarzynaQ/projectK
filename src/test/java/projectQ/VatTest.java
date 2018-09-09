package projectQ;

import org.junit.Test;
import projectQ.service.Model;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VatTest {

    @Test
    public void VatValueTest() {
        Invoice SUT = new Invoice();
        UserInterface ui=new UserInterface();
        Model model = ui.modelBuilder();
        SUT.setGross(123.0);
        SUT.setNetto(100.0);
        SUT.setVat(23);
        try {
            Method method = Model.class.getDeclaredMethod("vatValue", Invoice.class);
            method.setAccessible(true);
            try {
                assertEquals(23.0, method.invoke(model, SUT));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void VatValueZeroTest() {

        try {
            UserInterface ui=new UserInterface();
            Invoice SUT = new Invoice();
            Model model = ui.modelBuilder();
            SUT.setGross(100.0);
            SUT.setNetto(100.0);
            Method method=Model.class.getDeclaredMethod("vatValue", Invoice.class);
            method.setAccessible(true);
            assertEquals(0.0, method.invoke(model,SUT));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void VERSIONWithoutBUILDERVatBalanceTest() {
        UserInterface ui=new UserInterface();
        Invoice invoice1 = new Invoice();
        Invoice invoice2 = new Invoice();
        Invoice invoice3 = new Invoice();
        List<Invoice> invoiceList = new ArrayList<>();

        invoice1.setNetto(100.0);
        invoice2.setNetto(200.0);
        invoice3.setNetto(300.0);
        invoice1.setVat(23);
        invoice2.setVat(23);
        invoice3.setVat(23);
        try {
            invoice1.setBuyer(new NIP("123-456-32-18"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        try {
            invoice2.setBuyer(new NIP("123-456-32-18"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        try {
            invoice3.setBuyer(new NIP("123-456-32-18"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        invoiceList.add(invoice1);
        invoiceList.add(invoice2);
        invoiceList.add(invoice3);
        Model model = ui.modelBuilder();
        model.setMyInvoices(invoiceList);
        try {
            model.setMyNip(new NIP("953-253-56-63"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        assertEquals(138.0, model.balanceVat(), 000000.1);


        Invoice iAmBuyer = new Invoice();
        iAmBuyer.setNetto(200.0);
        iAmBuyer.setVat(23);
        iAmBuyer.setBuyer(model.getMyNip());

        invoiceList.add(iAmBuyer);
        model.setMyInvoices(invoiceList);
        assertEquals(92.0, model.balanceVat(), 0.000000001);

    }
    @Test
    public void vatFromFileTest(){
        UserInterface ui= new UserInterface();
        assertEquals(0.46,(ui.modelBuilder()).balanceVat(),0.0000001);
    }

}
