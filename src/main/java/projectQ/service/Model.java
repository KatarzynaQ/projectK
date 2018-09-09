package projectQ.service;

import lombok.Getter;
import lombok.Setter;
import projectQ.*;

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

    public Map<NIP,Double> myCommitments() {
        List<Invoice>invoicesUnPaid=unPaidAndCommitments(onlyUnPaid(myInvoices,bap));
        if(invoicesUnPaid==null){
         return null;
        }
        Map<NIP, Double>myCommitmentsWithValues=new HashMap<>();

        for (Invoice current:invoicesUnPaid) {
            Double sumOfCommitments=0.0;
            if (myCommitmentsWithValues == null) {

                myCommitmentsWithValues.put(current.getSeller(), sumOfCommitments);
            } else {

                if (!myCommitmentsWithValues.containsKey(current.getSeller())) {
                    sumOfCommitments=sumOfCommitments+current.getNetto();
                    myCommitmentsWithValues.put(current.getSeller(), sumOfCommitments);
                }
                else{
                    sumOfCommitments=myCommitmentsWithValues.get(current.getSeller())+current.getNetto();
                    myCommitmentsWithValues.put(current.getSeller(),sumOfCommitments);
                }
            }
        }
        return myCommitmentsWithValues;
    }
    public void myCommitmentsToString(){
        Map<NIP,Double>commitments=myCommitments();
        if (commitments==null){
            System.out.println("Nie masz zobowiązań");
        }
        System.out.println("Moje zobowiązania");
        for (NIP current:commitments.keySet()) {
            String key=current.toString();
            String value=commitments.get(current).toString();
            System.out.println("Jesteś winien firmie o numerze NIP: "+key+" "+value+ "zł");
        }
        System.out.println(" ");
    }

    public List<NIP> topFiveProviders() {
        List<Invoice> c = onlyProviders(myInvoices);
        Collections.sort(c, Collections.reverseOrder());
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

    public void topFiveProvidersToString() {
        List<NIP> toPrint = topFiveProviders();
        System.out.println("TOP 5 dostawców: ");
        for (NIP nip : toPrint) {
            System.out.print(nip.toString() + " ");
        }
        System.out.println(" ");
    }

    public List<Company> fiveContractors() {
        return null;
    }


    public Double accountBalance() {
        Double balance=0.0;
        for (BankAccount payment:bap) {
            if(payment.getOperationType().equals(OperationType.IN)){
                balance+=payment.getAmount();
            }else if(payment.getOperationType().equals(OperationType.OUT)){
                balance-=payment.getAmount();
            }
        }
        return balance;
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
    private List<Invoice> onlyProviders(List<Invoice> invoicesToFiltr) {
        List<Invoice> providers = new ArrayList<>();
        for (Invoice current : myInvoices
                ) {
            if (!current.getSeller().equals(myNip)) {

                providers.add(current);
            }
        }
        return providers;
    }

    public List<Invoice> onlyUnPaid(List<Invoice> invoicesToCheck, List<BankAccount> listOfPayments) {
        if (invoicesToCheck == null) {
            return null;
        } else if (listOfPayments == null) {
            Collections.sort(invoicesToCheck,Collections.reverseOrder());
            return invoicesToCheck;
        } else {
            List<Invoice> invoicesUnPaid = new ArrayList<>();
            for (Invoice current : invoicesToCheck) {
                String tittleOfInvoice = current.getTitleNumber();
                if (!isThisTittleOfPaymentInPayments(tittleOfInvoice, listOfPayments)) {
                    invoicesUnPaid.add(current);
                }
            }
            Collections.sort(invoicesUnPaid, Collections.reverseOrder());
            return invoicesUnPaid;
        }
    }

    private boolean isThisTittleOfPaymentInPayments(String tittle, List<BankAccount> allPayments) {
        for (BankAccount current : allPayments) {
            if (current.getTitleNumber().equals(tittle)) {
                return true;
            }
        }

        return false;
    }
    public List<Invoice>unPaidAndCommitments(List<Invoice>allUnPaid){
        List<Invoice>unPAC=new ArrayList<>();
        for (Invoice in:allUnPaid) {
            if(!in.getSeller().equals(myNip)){
                unPAC.add(in);
            }
        }
        return unPAC;
    }
}
