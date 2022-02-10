package main;

import entities.Account;
import entities.RawOperation;
import utils.ArrangeUtils;
import utils.CSVUtil;
import utils.EntitiesGenerator;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        CSVUtil util = new CSVUtil();
        ArrangeUtils arrangeUtils = new ArrangeUtils();
        EntitiesGenerator entitiesGenerator = new EntitiesGenerator();

        RawOperation[] arr = arrangeUtils.getArrangedRawList(util.getRawList()).toArray(new RawOperation[0]);
        Account[] accounts = entitiesGenerator.generateAccounts(arr);

        for (Account entry : accounts)
        {
            entry.runOperations(arr);
        }

        for (Account entry : accounts)
        {
            System.out.println(entry);
        }
    }
}
