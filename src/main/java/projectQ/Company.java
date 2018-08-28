package projectQ;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
    @CsvColumnName("name")
    private String name;
    @CsvColumnName("nip")
    private NIP nip;

    public Company(String name, NIP nip) {
        this.name = name;
        this.nip = nip;
    }
}


