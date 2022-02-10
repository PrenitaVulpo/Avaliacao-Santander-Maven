package utils;

import entities.Account;
import entities.RawOperation;

import java.math.BigDecimal;
import java.util.*;

public class EntitiesGenerator {
    final ArrangeUtils arrangeUtils = new ArrangeUtils();

//    public Account[] generateAccounts(ArrayList<RawOperation> operationsList){
//        ArrayList<Account> accountList = new ArrayList<>();
//
//        for(RawOperation operation : arrangeUtils.sortListByAccountID(operationsList)){
//
//            accountList.add(new Account(operation.getAccountID(), operation.getBankName(), operation.getAgencyNumber(), operation.getAccountNumber(), BigDecimal.ZERO));
//        }
//
//        Set<Account> filteredSet = new HashSet<>(arrangeUtils.sortAccountsByAccountID(accountList));
//        List<Account> filteredAccountList = new ArrayList<>(filteredSet);
//        return filteredAccountList.toArray(new Account[0]);
//    }

    public Account[] generateAccounts(RawOperation[] operationsList){
        Set<Account> set = new HashSet<>();

        for (int i = 0; i<operationsList.length;i++)
        {
            if (i != 0 && (!Objects.equals(operationsList[i - 1].getAccountID(), operationsList[i].getAccountID()))){
                set.add(new Account(
                        operationsList[i].getAccountID(),
                        operationsList[i].getBankName(),
                        operationsList[i].getAgencyNumber(),
                        operationsList[i].getAccountNumber(),
                        0,
                        new ArrayList<>())
                );
            }
        }

        List<Account> filteredAccountList = new ArrayList<>(set);
        return filteredAccountList.toArray(new Account[0]);
    }
}
