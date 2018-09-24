package by.insrchofsnrs.webapp.sevice.impl;

import by.insrchofsnrs.webapp.dto.UserDTOForUpdate;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.repository.UserRepository;
import by.insrchofsnrs.webapp.sevice.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateQueryException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        try {
            userRepository.save(user);
            log.info("User created. User info{}", user);
            return user;
        } catch (HibernateQueryException e) {
            log.error("Saving user in DB was failed. User {}", user);
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long userId) {
        try {
            userRepository.deleteById(userId);
            log.info("User was deleted. User id {}", userId);
            return true;
        } catch (HibernateQueryException e) {
            log.error("Deleting user by id was failed. User id {}", userId);
        }
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        if (!userRepository.findAll().isEmpty()) {
            log.info("Getting all users from db. Count {}", userRepository.findAll().size());
            return userRepository.findAll();
        }
        log.error("Getting all users from DB was failed.");
        return null;
    }

    @Override
    public User updateUser(Long userId, UserDTOForUpdate userDTO) {
        User user = userRepository.findUserById(userId);
        if (user!=null) {
            user.setBirthday(userDTO.getBirthday());
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setPhone2(userDTO.getPhone2());
            userRepository.save(user);
            log.info("Success updating user. User: {}", user);
            return user;
        }
        log.error("Updating user was failed. User was not founded");
        return null;
    }
}
