package by.users.yemialyanava.firstexample.mappers;

import by.users.yemialyanava.firstexample.dto.EmailDataDto;
import by.users.yemialyanava.firstexample.models.EmailData;

public class EmailMapper {
    public static EmailDataDto toEmailDto(EmailData email){
        return EmailDataDto.builder()
                .id(email.getId())
                .email(email.getEmail())
                .build();
    }

    public static EmailData toEmailEntity(EmailDataDto emailDto){
        return EmailData.builder()
                .id(emailDto.getId())
                .email(emailDto.getEmail())
                .build();
    }
}
