package by.users.yemialyanava.firstexample.services;

import by.users.yemialyanava.firstexample.models.User;
import by.users.yemialyanava.firstexample.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User read (Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with ID " + id + " not found"));
    }
}
