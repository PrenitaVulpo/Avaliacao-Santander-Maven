package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@Builder
@ToString
public class Operation {
    private String operator;
    private Date DateTime;
    private String operationType;
    private String value;
    private String accountID;
}
