package projectQ;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class BankAccount {

    @CsvColumnName("tittleNumber")
    private String titleNumber;
    @CsvColumnName("NIP")
    private String NIP;
    @CsvColumnName("amount")
    private Double amount;
    @CsvColumnName("data")
    private Date data;
    @CsvColumnName("operationType")
    private OperationType operationType;

    public BankAccount(String titleNumber, String NIP, Double amount, Date data, OperationType operationType) {
        this.titleNumber = titleNumber;
        this.NIP = NIP;
        this.amount = amount;
        this.data = data;
        this.operationType = operationType;
    }

    public BankAccount() {
    }
}
