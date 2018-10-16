package by.insrchofsnrs.webapp.sevice.impl;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.exception.UserNotFoundException;
import by.insrchofsnrs.webapp.pojo.User;
import by.insrchofsnrs.webapp.repository.UserRepository;
import by.insrchofsnrs.webapp.sevice.UserService;
import by.insrchofsnrs.webapp.util.converter.IMerger;
import by.insrchofsnrs.webapp.util.converter.impl.UserDTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateQueryException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserDTOConverter converter;

    @Autowired
    private IMerger<User, UserDto> merger;

    @Override
    public User createUser(UserDto userDto) {
        //Если все плохо получается вернет пустого юзвера? надо наверное после конвертера возращать его
        User result = new User();
        try {
            result = userRepository.save(converter.createUserFromDTO(userDto));
            log.info("User created. User info{}", result);
        } catch (HibernateQueryException e) {
            log.error("Saving user in DB was failed. User {}", userDto, e.getMessage());
        }
        return result;
    }

    @Override
    public boolean deleteUser(String id) {
        boolean result = false;
        Long userId = Long.parseLong(id);
        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new UserNotFoundException("User id: " + userId);
        }

        try {
            userRepository.deleteById(userId);
            log.info("User was deleted. User id {}", userId);
            result = true;
        } catch (HibernateQueryException e) {
            log.error("Deleting user by id was failed. User id {}", userId, e.getMessage());
        }
        return result;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> result = null;
        try {
            result = userRepository.findAll();
            log.info("Getting all users from db. Count {}", result);
        } catch (HibernateQueryException e) {
            log.error("Getting all users from DB was failed.", e.getMessage());
        }

        return result;
    }


    @Override
    public User updateUser(String id, UserDto userDto) {

        User result;
        long userId;
        try {
            userId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            log.warn("ID isn`t number. Details {}", e.getMessage());
            throw new UserNotFoundException("ID is not number");
        }

        Optional<User> user = userRepository.findById(userId);

        if (!user.isPresent()) {
            throw new UserNotFoundException("User id: " + userId);
        }

        /*
            merger = (t, k) -> {
            t.setPhone(k.getPhone());
            return t;
            };
        */

        result = merger.merge(user.get(), userDto);

        result.setId(userId);
        try {
            userRepository.save(result);
            log.info("Success updating user. User: {}", result);
        } catch (HibernateQueryException e) {
            log.error("Updating user was failed.", e.getMessage());
        }

        return result;
    }
}
