package by.users.yemialyanava.firstexample.dto;

import by.users.yemialyanava.firstexample.models.User;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailDataDto {
    private Long id;
    private User user;
    private String email;
}
