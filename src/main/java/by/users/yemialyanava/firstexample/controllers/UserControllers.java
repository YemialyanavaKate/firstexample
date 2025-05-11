package by.users.yemialyanava.firstexample.controllers;

import by.users.yemialyanava.firstexample.dto.UserDto;
import by.users.yemialyanava.firstexample.mappers.UserMapper;
import by.users.yemialyanava.firstexample.models.User;
import by.users.yemialyanava.firstexample.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserControllers {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> read (@PathVariable(name = "id") Long id){
        User user = userService.read(id);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }
}
