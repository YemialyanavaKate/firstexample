package by.users.yemialyanava.firstexample.repositories;

import by.users.yemialyanava.firstexample.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
