package projectQ;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    List<Invoice> myInvoices;
    List<BankAccount> myPayments;
    List<Company> myCompanies;
    NIP myNip;

    public Model modelBuilder() {
        try {
            myInvoices = InvoiceParser.readInvoice("C:\\workspace\\invoices.csv");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            myPayments = BankAccountParser.readBankPayment("C:\\workspace\\account.csv");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        myCompanies = CompanyParser.readCompanies("C:\\workspace\\companys.csv");
        try {
            myNip = new NIP("953-253-56-63");
        } catch (InvalidNipNumber invalidNipNumber) {
            invalidNipNumber.printStackTrace();
        }
        Model model = new Model(myInvoices, myCompanies, myPayments, myNip);
        return model;
    }

    /*
    choseMethod() uzytkownik za pomoca konsoli wybiera funkcjonalnosc
     */
    public void choseMethod() {
        boolean action = true;
        while (action) {

            System.out.println("wybierz funkcjonalność");
            System.out.println("[1] kto placi po terminie");
            System.out.println("[2] komu jestem winien");
            System.out.println("[3] TOP 5 dostawców");
            System.out.println("[4] TOP 5 kontrahentów");
            System.out.println("[5] bilans konta");
            System.out.println("[6] saldo po dostawcy");
            System.out.println("[7] saldo po kontrahentach");
            System.out.println("[8] VAT");
            System.out.println("[9] najblizsze platności");
            System.out.println("[10] raport obrotowy");
            System.out.println("[11] wyjscie");

            Scanner scanner = new Scanner(System.in);
            String chosing = scanner.next();
            switch (chosing) {
                case ("1"):
                    modelBuilder().delayPayment();
                    break;
                case ("2"):
                    modelBuilder().myCommitmentsToString();
                    break;
                case ("3"):
                    modelBuilder().topFiveProvidersToString();
                    break;
                case ("4"):
                    modelBuilder().fiveContractors();
                    break;
                case ("5"):
                    modelBuilder().accountBalance();
                    break;
                case ("6"):
                    modelBuilder().balancePerProvider();
                    break;
                case ("7"):
                    modelBuilder().balancePerContractor();
                    break;
                case ("8"):
                    System.out.println("VAT do zapłaty wynosi: "+modelBuilder().balanceVat()+" zł");
                    break;
                case ("9"):
                    modelBuilder().nearestPayments();
                    break;
                case ("10"):
                    modelBuilder().turnoverReport();
                    break;
                case ("11"):
                    action = false;
                    break;
                default:
                    System.out.println("sprobuj ponownie");

            }

        }
    }

}
