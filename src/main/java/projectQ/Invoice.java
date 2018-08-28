package projectQ;

import java.util.Date;

public class Invoice {
    private Long ID;
    private Company seller;
    private Company buyer;
    private Date invoiceDate;
    private Date paymentDate;
    private Double gross;
    private Double netto;
    private Integer vat;
    private String titleNumber;
}
