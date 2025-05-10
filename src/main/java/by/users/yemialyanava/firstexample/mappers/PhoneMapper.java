package by.users.yemialyanava.firstexample.mappers;

import by.users.yemialyanava.firstexample.dto.PhoneDataDto;
import by.users.yemialyanava.firstexample.models.PhoneData;

public class PhoneMapper {
    public static PhoneDataDto toPhoneDto(PhoneData phone){
        return PhoneDataDto.builder()
                .id(phone.getId())
                .phone(phone.getPhone())
                .build();
    }
    public static PhoneData toPhoneEntity (PhoneDataDto phoneDto){
        return PhoneData.builder()
                .id(phoneDto.getId())
                .phone(phoneDto.getPhone())
                .build();
    }
}
