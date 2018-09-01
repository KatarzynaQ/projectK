package projectQ;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public List<Company> myCommitment() {
    //   List<Invoice> c= onlyCommitments(myInvoices);
  return null;
    }

    public List<Company> fiveProviders() {
        return null;
    }

    public List<Company> fiveContractors() {
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
    private List<Invoice>onlyCommitments(List<Invoice>invoicesToFiltr){
        List<Invoice>commitments=new ArrayList<>();
        for (Invoice current: myInvoices
                ) {
            if(!current.getSeller().equals(myNip)){

                commitments.add(current);
            }
        }
        return commitments;
    }
}
