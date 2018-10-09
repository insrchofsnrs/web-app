package by.insrchofsnrs.webapp.sevice;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface UserService {

    /**
     * Create users.
     * @param userDTO
     * @return user after creation
     */
    User createUser(UserDto userDto);

    /**
     * Delete user by id.
     * @param userId
     * @return true if user was deleted
     */
    boolean deleteUser(String userId);

    /**
     * Get all users.
     * @return Collection with all users from DB
     */
    List<User> getAllUsers ();

    /**
     * Update user.
     * @param id, userDTO
     * @return updated user or non-updated user
     */
    User updateUser (String id, UserDto userDto);
}


