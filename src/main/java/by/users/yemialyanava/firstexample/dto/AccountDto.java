package by.users.yemialyanava.firstexample.dto;

import by.users.yemialyanava.firstexample.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    private Long id;
    private User user;
    private BigDecimal balance;
}
