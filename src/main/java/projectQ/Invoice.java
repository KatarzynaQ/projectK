package projectQ;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class Invoice {
    @CsvColumnName("ID")
    private Long ID;

    @CsvColumnName("seller")
    private Company seller;

    @CsvColumnName("buyer")
    private Company buyer;

    @CsvColumnName("invoiceDate")
    private Date invoiceDate;

    @CsvColumnName("paymentDate")
    private Date paymentDate;

    @CsvColumnName("gross")
    private Double gross;

    @CsvColumnName("netto")
    private Double netto;

    @CsvColumnName("vat")
    private Integer vat;

    @CsvColumnName("tittleNumber")
    private String titleNumber;

    public Invoice(Long ID, Company seller, Company buyer, Date invoiceDate, Date paymentDate, Double gross, Double netto, Integer vat, String titleNumber) {
        this.ID = ID;
        this.seller = seller;
        this.buyer = buyer;
        this.invoiceDate = invoiceDate;
        this.paymentDate = paymentDate;
        this.gross = gross;
        this.netto = netto;
        this.vat = vat;
        this.titleNumber = titleNumber;
    }

    public Invoice() {
    }
}
