package by.users.yemialyanava.firstexample.dto;

import by.users.yemialyanava.firstexample.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneDataDto {
    private Long id;
    private User user;
    private String phone;
}
