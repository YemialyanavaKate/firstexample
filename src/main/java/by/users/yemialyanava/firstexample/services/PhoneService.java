package by.users.yemialyanava.firstexample.services;

import by.users.yemialyanava.firstexample.models.PhoneData;
import by.users.yemialyanava.firstexample.models.User;
import by.users.yemialyanava.firstexample.repositories.PhoneDataRepository;
import by.users.yemialyanava.firstexample.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhoneService {
    private final PhoneDataRepository phoneDataRepository;
    private final UserRepository userRepository;

    public PhoneData readPhone(Long id) {
        return phoneDataRepository.findById(id).orElseThrow(() -> new RuntimeException("Phone with ID " + id + " not found"));
    }

    @Transactional
    public PhoneData addPhone(Long userId, PhoneData phoneData) {
        return userRepository.findById(userId)
                .map(user -> {
                    Optional<PhoneData> existingPhone = phoneDataRepository.findByPhone(phoneData.getPhone());
                    if (existingPhone.isPresent()) {
                        throw new RuntimeException("Phone number " + phoneData.getPhone() + " is already used by another user");
                    }

                    if (user.getPhones() == null) {
                        user.setPhones(new ArrayList<>());
                    }

                    if (phoneData.getUser() == null) {
                        phoneData.setUser(user);
                    }

                    user.getPhones().add(phoneData);
                    return phoneDataRepository.save(phoneData);
                }).orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
    }

    @Transactional
    public void deletePhone(Long userId, Long phoneId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));

        PhoneData phoneData = phoneDataRepository.findById(phoneId)
                .orElseThrow(() -> new RuntimeException("Phone with ID " + phoneId + " not found"));

        if (user.getPhones().contains(phoneData)) {
            user.getPhones().remove(phoneData);
            phoneDataRepository.delete(phoneData);
            userRepository.save(user);
        } else {
            throw new RuntimeException("Phone with ID " + phoneId + " not found");
        }
    }

    @Transactional
    public PhoneData updatePhone(Long userId, PhoneData newPhoneData) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));
        PhoneData phoneDataForUpdate = phoneDataRepository.findById(newPhoneData.getId())
                .orElseThrow(() -> new RuntimeException("Phone with ID " + newPhoneData.getId() + " not found"));

        if (!user.getPhones().contains(phoneDataForUpdate)) {
            throw new RuntimeException("Phone with ID " + newPhoneData.getId() + " not found");
        }
        phoneDataForUpdate.setPhone(newPhoneData.getPhone());
        return phoneDataRepository.save(phoneDataForUpdate);
    }

}
