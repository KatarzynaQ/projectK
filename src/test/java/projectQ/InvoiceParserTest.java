package projectQ;

import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvoiceParserTest {

    @Test
    public void checkingInvoiceListSize() {
        List<Invoice> invoices = new ArrayList<>();
        try {
            invoices = InvoiceParser.readInvoice("C:\\workspace\\invoices.csv");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        assertEquals(3, invoices.size());
    }

    @Test
    public void readFirstInvoiceTest() throws ParseException, IOException {
        Invoice SUT = new Invoice();
        SUT.setVat(23);
        SUT.setNetto(3.0);
        SUT.setGross(3.69);
        SUT.setPaymentDate(SUT.parsingDateFromString("27-09-2018"));
        SUT.setInvoiceDate(SUT.parsingDateFromString("28-08-2018"));
        try {
            SUT.setBuyer(new NIP("5621807397"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        try {
            SUT.setSeller(new NIP("9532535663"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        SUT.setTitleNumber("FS/1/2018");

        String path = "C:\\workspace\\invoices.csv";
        InvoiceParser ip = new InvoiceParser();
        List<Invoice> invoices = new ArrayList<>();
        invoices = ip.readInvoice(path);

        // assertEquals(true,(SUT.equals(invoices.get(0))));

        assertEquals(3, invoices.size());

        assertEquals(SUT.getBuyer().toString(), (invoices.get(0)).getBuyer().toString());
        assertEquals(SUT.getSeller().toString(), (invoices.get(0)).getSeller().toString());
        assertEquals(SUT.getGross(), (invoices.get(0)).getGross());
        assertEquals(SUT.getNetto(), (invoices.get(0)).getNetto());
        assertEquals(SUT.getVat(), (invoices.get(0)).getVat());
        assertEquals(SUT.getPaymentDate(), (invoices.get(0)).getPaymentDate());
        assertEquals(SUT.getInvoiceDate(), (invoices.get(0)).getInvoiceDate());
        assertEquals(SUT.getTitleNumber(), (invoices.get(0)).getTitleNumber());
    }

    @Test
    public void readSecondInvoiceTest() throws ParseException {
        Invoice SUT = new Invoice();
        SUT.setVat(23);
        SUT.setNetto(1.0);
        SUT.setGross(1.23);
        SUT.setPaymentDate(SUT.parsingDateFromString("27-09-2018"));
        SUT.setInvoiceDate(SUT.parsingDateFromString("28-08-2018"));
        try {
            SUT.setBuyer(new NIP("5592019621"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        try {
            SUT.setSeller(new NIP("9532535663"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        SUT.setTitleNumber("FS/2/2018");

        String path = "C:\\workspace\\invoices.csv";
        InvoiceParser ip = new InvoiceParser();
        List<Invoice> invoices = new ArrayList<>();
        try {
            invoices = ip.readInvoice(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(new Integer(3), new Integer(invoices.size()));

        assertEquals(SUT.getBuyer().toString(), (invoices.get(1)).getBuyer().toString());
        assertEquals(SUT.getSeller().toString(), (invoices.get(1)).getSeller().toString());
        assertEquals(SUT.getGross(), (invoices.get(1)).getGross());
        assertEquals(SUT.getNetto(), (invoices.get(1)).getNetto());
        assertEquals(SUT.getVat(), (invoices.get(1)).getVat());
        assertEquals(SUT.getPaymentDate(), (invoices.get(1)).getPaymentDate());
        assertEquals(SUT.getInvoiceDate(), (invoices.get(1)).getInvoiceDate());
        assertEquals(SUT.getTitleNumber(), (invoices.get(1)).getTitleNumber());
    }

    @Test
    public void readThirdInvoice() throws ParseException {
        Invoice SUT = new Invoice();
        SUT.setVat(23);
        SUT.setNetto(2.0);
        SUT.setGross(2.46);
        SUT.setPaymentDate(SUT.parsingDateFromString("27-09-2018"));
        SUT.setInvoiceDate(SUT.parsingDateFromString("28-08-2018"));
        try {
            SUT.setBuyer(new NIP("9532535663"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        try {
            SUT.setSeller(new NIP("6692359802"));
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        SUT.setTitleNumber("FZ/1/2018");

        String path = "C:\\workspace\\invoices.csv";
        InvoiceParser ip = new InvoiceParser();
        List<Invoice> invoices = new ArrayList<>();
        try {
            invoices = ip.readInvoice(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(new Integer(3), new Integer(invoices.size()));
        assertEquals(SUT.getBuyer().toString(), (invoices.get(2)).getBuyer().toString());
        assertEquals(SUT.getSeller().toString(), (invoices.get(2)).getSeller().toString());
        assertEquals(SUT.getGross(), (invoices.get(2)).getGross());
        assertEquals(SUT.getNetto(), (invoices.get(2)).getNetto());
        assertEquals(SUT.getVat(), (invoices.get(2)).getVat());
        assertEquals(SUT.getPaymentDate(), (invoices.get(2)).getPaymentDate());
        assertEquals(SUT.getInvoiceDate(), (invoices.get(2)).getInvoiceDate());
        assertEquals(SUT.getTitleNumber(), (invoices.get(2)).getTitleNumber());

    }

}
