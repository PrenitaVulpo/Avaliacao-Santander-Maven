package entities;

import Enums.OperationType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@ToString
public class Operation {
    private String operator;
    private String DateTime;
    private OperationType operationType;
    private BigDecimal value;
    private Account account;
}
