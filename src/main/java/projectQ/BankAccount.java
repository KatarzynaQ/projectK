package projectQ;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Getter
@Setter
public class BankAccount {

    @CsvColumnName("tytul")
    private String titleNumber;
    @CsvColumnName("nipSprzedawcyNabywcy")
    private NIP NIP;
    @CsvColumnName("amount")
    private Double amount;
    @CsvColumnName("data")
    private Date data;
    @CsvColumnName("operationType")
    private OperationType operationType;

    public BankAccount(String titleNumber, NIP NIP, Double amount, Date data, OperationType operationType) {
        this.titleNumber = titleNumber;
        this.NIP = NIP;
        this.amount = amount;
        this.data = data;
        this.operationType = operationType;
    }


    public BankAccount() {
    }

    public Date parsingDateFromString(String s) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date dt = df.parse(s);
        return dt;
    }
}
