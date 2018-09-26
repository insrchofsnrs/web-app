package by.insrchofsnrs.webapp.sevice.impl;

import by.insrchofsnrs.webapp.dto.UserDTOForUpdateAndCreate;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.repository.UserRepository;
import by.insrchofsnrs.webapp.sevice.UserService;
import by.insrchofsnrs.webapp.util.converter.impl.UserDTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateQueryException;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOConverter converter;

    @Override
    public User createUser(User user) {
        User result = user;
        try {
            result = userRepository.save(user);
            log.info("User created. User info{}", user);
        } catch (HibernateQueryException e) {
            log.error("Saving user in DB was failed. User {}", user);
        }
        return result;
    }

    @Override
    public boolean deleteUser(Long userId) {
        boolean result = false;
        try {
            userRepository.deleteById(userId);
            log.info("User was deleted. User id {}", userId);
            result = true;
        } catch (HibernateQueryException e) {
            log.error("Deleting user by id was failed. User id {}", userId);
        }
        return result;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = null;
        try {
            result = userRepository.findAll();
            log.info("Getting all users from db. Count {}", result);
        } catch (HibernateQueryException e){
            log.error("Getting all users from DB was failed.");
        }

        return result;
    }

    @Override
    public User updateUser(Long userId, UserDTOForUpdateAndCreate userDTO) {

        User result = null;

        try {
            result = userRepository.findUserById(userId);
        } catch (HibernateQueryException e) {
            log.error("User {} not found", userId, e.getMessage());
        }

        try {
            result = userRepository.save(converter.createUserFromDTO(userDTO));
            log.info("Success updating user. User: {}", result);
        } catch (HibernateQueryException e) {
            log.error("Updating user was failed.", e.getMessage());
        }

        return result;
    }
}
