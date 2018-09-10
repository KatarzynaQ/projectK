package projectQ.service;

import projectQ.Company;
import projectQ.Invoice;
import projectQ.NIP;

import java.util.*;

public class InvoicesCounter {
    private List<Invoice> myInvoices;
    private NIP myNip;

    public InvoicesCounter(List<Invoice> myInvoices, NIP myNip) {
        this.myInvoices = myInvoices;
        this.myNip = myNip;
    }


    public Map<NIP, Double> addingValuesIntoCompanies(List<Invoice> invoices) {

        Map<NIP, Double> providersWithValues = new HashMap<>();
        if (invoices == null) {
            return null;
        }
        Map<NIP, Double> companiesWithValues = new HashMap<>();

        for (Invoice current : invoices) {
            Double sumOfCommitments = 0.0;
            if (companiesWithValues == null) {

                companiesWithValues.put(current.getSeller(), sumOfCommitments);
            } else {

                if (!companiesWithValues.containsKey(current.getSeller())) {
                    sumOfCommitments = sumOfCommitments + current.getNetto();
                    companiesWithValues.put(current.getSeller(), sumOfCommitments);
                } else {
                    sumOfCommitments = companiesWithValues.get(current.getSeller()) + current.getNetto();
                    companiesWithValues.put(current.getSeller(), sumOfCommitments);
                }
            }
        }
        return companiesWithValues;
    }


   public Map<NIP, Double> companiesToReturn() {
        Map<NIP, Double> toReturnMap = new HashMap<>();
        List<Invoice> c = onlyProviders();
        Collections.sort(c);
        if (c.size() < 5) {
            return addingValuesIntoCompanies(c);
        } else {
            Map<NIP, Double> onlyFive = new HashMap<>();
            for (int i = 0; i < 5; i++) {
                onlyFive.put((c.get(i)).getSeller(), toReturnMap.get(c));
            }
            return onlyFive;
        }
    }

//    public void topFiveProvidersToString() {
//        Map<NIP,Double> toPrint = companiesToReturn();
//        System.out.println("TOP 5 dostawców: ");
//        for (NIP nip : toPrint) {
//            System.out.print(nip.toString() + " ");
//        }
//        System.out.println(" ");
//    }

    private List<Invoice> onlyProviders() {
        List<Invoice> providers = new ArrayList<>();
        for (Invoice current : myInvoices
                ) {
            if (!current.getSeller().equals(myNip)) {

                providers.add(current);
            }
        }
        return providers;
    }

    public List<Company> fiveContractors() {
        return null;
    }


}
