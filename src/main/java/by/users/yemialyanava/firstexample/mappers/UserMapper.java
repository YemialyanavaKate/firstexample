package by.users.yemialyanava.firstexample.mappers;

import by.users.yemialyanava.firstexample.dto.AccountDto;
import by.users.yemialyanava.firstexample.dto.EmailDataDto;
import by.users.yemialyanava.firstexample.dto.PhoneDataDto;
import by.users.yemialyanava.firstexample.dto.UserDto;
import by.users.yemialyanava.firstexample.models.Account;
import by.users.yemialyanava.firstexample.models.EmailData;
import by.users.yemialyanava.firstexample.models.PhoneData;
import by.users.yemialyanava.firstexample.models.User;

import java.util.Collections;
import java.util.List;

public class UserMapper {
    public static UserDto toDto(User user) {
        List<PhoneDataDto> phonesDto = user.getPhones() != null ?
                user.getPhones()
                        .stream()
                        .map(PhoneMapper::toPhoneDto)
                        .toList() :
                Collections.emptyList();

        List<EmailDataDto> emailDto = user.getEmails() != null ?
                user.getEmails()
                        .stream()
                        .map(EmailMapper::toEmailDto)
                        .toList() :
                Collections.emptyList();
        AccountDto accountDto = user.getAccount() != null
                ? AccountMapper.toAccountDto(user.getAccount()) :
                null;

        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .date_of_birth(user.getDate_of_birth())
                .account(accountDto)
                .phones(phonesDto)
                .emails(emailDto)
                .build();
    }

    public static User toEntity(UserDto userDto) {
        List<PhoneData> phones = userDto.getPhones() != null ?
                userDto.getPhones()
                        .stream()
                        .map(PhoneMapper::toPhoneEntity)
                        .toList() :
                Collections.emptyList();

        List<EmailData> emails = userDto.getEmails() != null ?
                userDto.getEmails()
                        .stream()
                        .map(EmailMapper::toEmailEntity)
                        .toList() :
                Collections.emptyList();
        Account account = userDto.getAccount() != null
                ? AccountMapper.toAccountEntity(userDto.getAccount())
                : null;

        return User.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .date_of_birth(userDto.getDate_of_birth())
                .account(account)
                .phones(phones)
                .emails(emails)
                .build();
    }
}
