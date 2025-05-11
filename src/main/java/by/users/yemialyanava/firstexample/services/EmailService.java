package by.users.yemialyanava.firstexample.services;

import by.users.yemialyanava.firstexample.models.EmailData;
import by.users.yemialyanava.firstexample.repositories.EmailDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final EmailDataRepository emailDataRepository;

    public EmailData readEmail(Long id) {
        return emailDataRepository.findById(id).orElseThrow(() -> new RuntimeException("Email with ID " + id + " not found"));
    }
}
