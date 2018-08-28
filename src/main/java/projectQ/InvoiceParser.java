package projectQ;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
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

    public Invoice readInvoice(String invoicePath) throws IOException {
        Invoice invoiceRead = new Invoice();
        BufferedReader br = null;
        FileReader fReader = null;
        Map<Integer, String> headerLine = new HashMap<>();

        try {
            br = new BufferedReader(fReader);
            fReader = new FileReader(invoicePath);
            boolean firstLine = true;
            String line;

            while ((line = br.readLine()) != null) {
                Map<String, String> columnData = new HashMap<>();
                if (firstLine) {
                    firstLine = false;
                    String[] data = line.split(";");

                    for (int i = 0; i < data.length; i++) {
                        headerLine.put(i, data[i]);
                    }
                } else {
//                    columnData.put()
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
return null;
    }
}