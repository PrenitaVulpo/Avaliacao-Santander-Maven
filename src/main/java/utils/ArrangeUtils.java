package utils;

import entities.Account;
import entities.RawOperation;

import java.util.*;

public class ArrangeUtils {
    public ArrayList<RawOperation> sortListByAccountID(ArrayList<RawOperation> list) {
        list.sort((operation1, operation2) -> {
            // avoiding NullPointerException in case name is null
            if (operation1.getAccountID() == null && operation2.getAccountID() == null) {
                return 0;
            }
            if (operation1.getAccountID() == null) {
                return -1;
            }
            if (operation2.getAccountID() == null) {
                return 1;
            }
            return operation1.getAccountID().compareTo(operation2.getAccountID());
        });
        return list;
    }

    public ArrayList<RawOperation> filterRawList(ArrayList<RawOperation> list){
        Set<RawOperation> filteredSet = new LinkedHashSet<>(list);

        return new ArrayList<>(filteredSet);
    }

    public ArrayList<RawOperation> getArrangedRawList(ArrayList<RawOperation> list){
        return filterRawList(sortListByAccountID(list));
    }

    public List<Map<String,String>> filterMapList(List<Map<String,String>> list){
        Set<Map<String, String>> filteredSet = new HashSet<>(list);

        return new ArrayList<>(filteredSet);
    }

    public ArrayList<Account> sortAccountsByAccountID(ArrayList<Account> list) {

        Comparator<Account> compareById = Comparator.comparing(Account::getID);
        list.sort((operation1, operation2) -> {
            // avoiding NullPointerException in case name is null
            if (operation1.getID() == null && operation2.getID() == null) {
                return 0;
            }
            if (operation1.getID() == null) {
                return -1;
            }
            if (operation2.getID() == null) {
                return 1;
            }
            return operation1.getID().compareTo(operation2.getID());
        });
        list.sort(compareById);
        return list;
    }


}
