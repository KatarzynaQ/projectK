package projectQ;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceParser {
    private final Map<String, String> mapFieldsToColumn = new HashMap<>();

//    public Map<String, String> getAnnotations() {
//        Field[] f = Invoice.class.getDeclaredFields();
//        for (Field x : f) {
//            Annotation[] an = x.getAnnotationsByType(CsvColumnName.class);
//            if (an != null) {
//                for (Annotation a : an) {
//                    mapFieldsToColumn.put(a.value(), x.getName());
//                }
//            }
//        }
//    }

    public static List<Invoice> readInvoice(String invoicePath) throws IOException, ParseException {
        FileReader fr = null;
        BufferedReader br = null;
        String line;
        List<Invoice> invoices = new ArrayList<>();

        try {
            fr = new FileReader(invoicePath);
            br = new BufferedReader(fr);
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }
                Invoice i = new Invoice();
                String[] data = line.split(";");
                i.setTitleNumber(data[0]);
                try {
                    i.setSeller(new NIP(data[1]));
                } catch (InvalidNipNumber invalidNipNumber) {
                    invalidNipNumber.printStackTrace();
                }
                try {
                    i.setBuyer(new NIP(data[2]));
                } catch (InvalidNipNumber invalidNipNumber) {
                    invalidNipNumber.printStackTrace();
                }
                i.setInvoiceDate(i.parsingDateFromString(data[3]));
                i.setPaymentDate(i.parsingDateFromString(data[4]));
                i.setGross(Double.valueOf(data[5]));
                i.setNetto(Double.valueOf(data[6]));
                i.setVat(Integer.valueOf(data[7]));
                invoices.add(i);


            }
            return invoices;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return invoices;
    }


}