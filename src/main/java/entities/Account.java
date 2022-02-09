package entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Account {
    private String ID;
    private String bankName;
    private int agencyNumber;
    private String accountNumber;
}
