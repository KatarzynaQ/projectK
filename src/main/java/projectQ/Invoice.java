package projectQ;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Getter
@Setter
public class Invoice {

    private Long ID;

    @CsvColumnName("NipSprzedawcy")
    private Company seller;

    @CsvColumnName("NipNabywcy")
    private Company buyer;

    @CsvColumnName("DataWystawienia")
    private Date invoiceDate;

    @CsvColumnName("DataPlatnosci")
    private Date paymentDate;

    @CsvColumnName("Brutto")
    private Double gross;

    @CsvColumnName("Netto")
    private Double netto;

    @CsvColumnName("StawkaVat")
    private Integer vat;

    @CsvColumnName("NumerFaktury")
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

    public Date parsingDateFromString(String s) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date dt = df.parse(s);
        return dt;
    }
}
