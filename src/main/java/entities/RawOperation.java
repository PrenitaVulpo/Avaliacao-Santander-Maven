package entities;

import lombok.*;


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
    private String AccountID;
    private String bankName;
    private String agencyNumber;
    private String accountNumber;

}
