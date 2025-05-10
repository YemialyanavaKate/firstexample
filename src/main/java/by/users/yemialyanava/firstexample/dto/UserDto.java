package by.users.yemialyanava.firstexample.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    private Long id;
    private String name;
    private LocalDate date_of_birth;
    private AccountDto account;
    private List<PhoneDataDto> phones;
    private List<EmailDataDto> emails;
}
