package entities;

import Enums.OperationType;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class RawOperation {
    private String operator;
    private String DateTime;
    private String operationType;
    private String value;
    private String ID;
    private String bankName;
    private String agencyNumber;
    private String accountNumber;

}
