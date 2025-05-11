package by.users.yemialyanava.firstexample.controllers;

import by.users.yemialyanava.firstexample.dto.PhoneDataDto;
import by.users.yemialyanava.firstexample.models.PhoneData;
import by.users.yemialyanava.firstexample.services.PhoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static by.users.yemialyanava.firstexample.mappers.PhoneMapper.toPhoneDto;
import static by.users.yemialyanava.firstexample.mappers.PhoneMapper.toPhoneEntity;

@RequiredArgsConstructor
@RestController
@RequestMapping("/phone")
public class PhoneDataController {
    private final PhoneService phoneService;

    @PostMapping("/create/{id}")
    public ResponseEntity<PhoneDataDto> addPhone(@PathVariable(name = "id") Long id, @RequestBody PhoneDataDto phoneDataDto) {
        PhoneData phoneData = toPhoneEntity(phoneDataDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(toPhoneDto(phoneService.addPhone(id, phoneData)));
    }

    @DeleteMapping("/{id}/delete/{phone_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePhone(@PathVariable(name = "id") Long userId, @PathVariable(name = "phone_id") Long phoneId) {
        phoneService.deletePhone(userId, phoneId);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<PhoneDataDto> updatePhone(@PathVariable(name = "id") Long id, @RequestBody PhoneDataDto phoneDataDto) {
        PhoneData phoneData = toPhoneEntity(phoneDataDto);
        return ResponseEntity.status(HttpStatus.OK).body(toPhoneDto(phoneService.updatePhone(id, phoneData)));
    }

}
