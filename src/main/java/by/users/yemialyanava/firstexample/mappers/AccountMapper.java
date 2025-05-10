package by.users.yemialyanava.firstexample.mappers;

import by.users.yemialyanava.firstexample.dto.AccountDto;
import by.users.yemialyanava.firstexample.models.Account;

public class AccountMapper {
    public static AccountDto toAccountDto(Account account) {
        return AccountDto.builder()
                .id(account.getId())
                .balance(account.getBalance())
                .build();
    }

    public static Account toAccountEntity(AccountDto accountDto) {
        return Account.builder()
                .id(accountDto.getId())
                .balance(accountDto.getBalance())
                .build();
    }
}
