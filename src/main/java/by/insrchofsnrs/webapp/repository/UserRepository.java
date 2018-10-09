package by.insrchofsnrs.webapp.repository;

import by.insrchofsnrs.webapp.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById (Long id);

}
