package projectQ.service;

import projectQ.BankAccount;
import projectQ.OperationType;

import java.util.List;

public class AccountCounter {
    private List<BankAccount> bap;

    public AccountCounter(List<BankAccount> bap) {
        this.bap = bap;
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
}
