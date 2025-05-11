package by.users.yemialyanava.firstexample.repositories;

import by.users.yemialyanava.firstexample.models.EmailData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailDataRepository extends JpaRepository<EmailData, Long> {
}
