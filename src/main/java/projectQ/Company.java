package projectQ;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
    @CsvColumnName("name")
    private String name;
    @CsvColumnName("nip")
    private String nip;

    public Company(String name, String nip) {
        this.name = name;
        this.nip = nip;
    }

    public Company() {
    }
}


