package projectQ;

import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

@Getter
@Setter
public class Invoice implements Comparable<Invoice> {


    @CsvColumnName("NipSprzedawcy")
    private NIP seller;

    @CsvColumnName("NipNabywcy")
    private NIP buyer;

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

    public Invoice(NIP seller, NIP buyer, Date invoiceDate, Date paymentDate, Double gross, Double netto, Integer vat, String titleNumber) {
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
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
        Date dt = df.parse(s);
        return dt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return Objects.equals(this.seller, invoice.seller) &&
                Objects.equals(this.buyer, invoice.buyer) &&
                Objects.equals(this.invoiceDate, invoice.invoiceDate) &&
                Objects.equals(this.paymentDate, invoice.paymentDate) &&
                Objects.equals(this.gross, invoice.gross) &&
                Objects.equals(this.netto, invoice.netto) &&
                Objects.equals(this.vat, invoice.vat) &&
                Objects.equals(this.titleNumber, invoice.titleNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(seller, buyer, invoiceDate, paymentDate, gross, netto, vat, titleNumber);
    }



    @Override
    public int compareTo(Invoice o) {
        if (getNetto() == null || o.getNetto() == null) {
            return 0;
        }
        return getNetto().compareTo(o.getNetto());
    }
}
