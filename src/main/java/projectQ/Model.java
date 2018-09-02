package projectQ;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class Model {
    //public String pathCompany;
    // public String pathInvoice;
    // public String pathAccount;
    public List<Invoice> myInvoices;
    public List<Company> myCompanies;
    public List<BankAccount> bap;
    public Date today;
    public NIP myNip;

    public Model(List<Invoice> myInvoices, List<Company> cp, List<BankAccount> bap, NIP nip) {
        //this.pathAccount = pathAccount;
        // this.pathCompany = pathCompany;
        // this.pathInvoice = pathInvoice;

        this.myInvoices = myInvoices;
        this.myCompanies = cp;
        this.bap = bap;
        this.today = new Date();
        this.myNip = nip;


    }

    public List<Company> delayPayment() {
        return null;
    }

    public List<NIP> topFiveProviders() {
        List<Invoice> c = onlyProviders(myInvoices);
        Collections.sort(c,Collections.reverseOrder());
        List<NIP> companiesToReturn = new ArrayList<>();
        if (c.size() < 5) {
            for (Invoice current : c
                    ) {
                companiesToReturn.add(current.getSeller());
            }
            return companiesToReturn;
        } else {
            for (int i = 0; i < 5; i++) {
                companiesToReturn.add((c.get(i)).getSeller());
            }
            return companiesToReturn;
        }
    }
    public void topFiveProvidersToString(){
        List<NIP>toPrint= topFiveProviders();
        System.out.println("TOP 5 dostawców: ");
        for (NIP nip:toPrint) {
            System.out.print(nip.toString()+ " ");
        }
        System.out.println(" ");
    }
    public List<Company> fiveCommitments() {
        return null;
    }

    public List<Company> myCommitments() {
        return null;
    }

    public Double accountBalance() {
        return null;
    }

    public Double balancePerProvider() {
        return null;
    }

    public Double balancePerContractor() {
        return null;
    }

    public Double balanceVat() {
        Double vatToPay = 0.0;
        for (Invoice current : myInvoices) {
            Double currentVatValue = vatValue(current);
            if (current.getBuyer().equals(myNip)) {
                vatToPay = vatToPay - currentVatValue;
            } else {
                vatToPay = vatToPay + currentVatValue;
            }
        }
        return vatToPay;
    }

    private Double vatValue(Invoice invoice) {
        return ((invoice.getNetto()) * 0.01 * (invoice.getVat()));
    }

    public List<Invoice> nearestPayments() {
        return null;
    }

    public void turnoverReport() {
    }


    /*
    * this method returns list of invoices
     * which are only commitments from all invoices
    * */
    private List<Invoice> onlyProviders(List<Invoice>invoicesToFiltr){
        List<Invoice>providers=new ArrayList<>();
        for (Invoice current: myInvoices
                ) {
            if(!current.getSeller().equals(myNip)){

                providers.add(current);
            }
        }
        return providers;
    }
}
