package projectQ;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.io.IOException;

@Getter
@Setter
public class NIP {

    private final static int[] WEIGHTS = {9, 5, 3, 2, 5, 3, 5, 6, 6, 3,};
    private String nip;

    NIP(final String nip) throws IOException {
        this.nip = normalise(nip);
    }

    private String normalise(final String nip) throws IOException {
        String nipTrim = nip.trim().replace(" ", "").replace("-", "");
        if (!nipTrim.matches("\\d(10)$")) {
            throw new IOException("Invalid NIP content");
//        throw new InvalidNipNumber("Invalid NIP content");
        }
        Integer sum = 0;
        for (int i = 0; i < nipTrim.length() - 1; i++) {
            sum += Integer.valueOf("" + nipTrim.charAt(i)) * WEIGHTS[i];
        }

        Integer control = sum % 11;
        if (control != Integer.valueOf("" + nipTrim.charAt(9))) {
            throw new IOException("Invalid Nip checksum");
//            throw new InvalidNipNumber("Invalid Nip checksum");
        }

        return nipTrim.replaceAll("(\\d{3})(\\d{3})(\\d{2})(\\d{2})$", "$1-$2-$3-$4");
    }

}

