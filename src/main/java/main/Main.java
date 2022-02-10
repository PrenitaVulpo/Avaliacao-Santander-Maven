package main;

import entities.Account;
import entities.Operation;
import entities.RawOperation;
import utils.ArrangeUtils;
import utils.CSVUtil;
import utils.EntitiesGenerator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws ParseException, IOException {
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

        for (Account entry : accounts)
        {
            Path file = Paths.get(entry.getID()+".txt");
            String header = "Conta: " + entry.getAccountNumber() +"\n"
                    + "Agência: " + entry.getAgencyNumber() + "\n"
                    + "Saldo: " + entry.getAgencyNumber() + "\n\n\n"
                    + "Extrato: \n\n";
            StringBuilder text = new StringBuilder();

            for (Operation opp : entry.getBankStatement()){
                String iterationText = "Operador: " + opp.getOperator() + "\n"
                        + "Data: " + opp.getDateTime() + "\n"
                        + "Tipo: " + opp.getOperationType() + "\n"
                        + "Valor: " + opp.getValue() + "\n"
                        + "================================\n";

                text.append(iterationText);
            }

            Files.writeString(file, header + text);
        }


    }
}
