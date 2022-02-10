package entities;

import lombok.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class Account {
    private String ID;
    private String bankName;
    private String agencyNumber;
    private String accountNumber;
    private double balance;
    private List<Operation> bankStatement;


    public void runOperation(RawOperation operation){
        if (Objects.equals(operation.getOperationType(), "SAQUE")){
            this.balance = this.balance - Double.parseDouble(operation.getValue());
        }
        if (Objects.equals(operation.getOperationType(), "DEPOSITO")){
            this.balance = this.balance + Double.parseDouble(operation.getValue());
        }
    }

    public void sortBankStatement(){
        this.bankStatement.sort(Comparator.comparing(Operation::getDateTime));
    }

    public void runOperations(RawOperation[] operations) throws ParseException {
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        for (RawOperation operation : operations){
            if(Objects.equals(operation.getAccountID(), this.ID)){
                runOperation(operation);
                this.bankStatement.add(new Operation(
                        operation.getOperator(),
                        df1.parse(operation.getDateTime()),
                        operation.getOperationType(),
                        operation.getValue(),
                        operation.getAccountID()
                ));
            }
        }

        sortBankStatement();
    }
}
