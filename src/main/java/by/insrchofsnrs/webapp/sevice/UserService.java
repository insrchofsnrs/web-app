package by.insrchofsnrs.webapp.sevice;

import by.insrchofsnrs.webapp.dto.UserDTOForUpdateAndCreate;
import by.insrchofsnrs.webapp.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    /**
     * Create users.
     * @param userDTO
     */
    User createUser(User userDTO);

    /**
     * Delete user by id.
     * @param userId
     */
    boolean deleteUser(Long userId);

    /**
     * Get all users.
     * @return что тут обычно пишут7
     */
    List<User> getAllUsers ();

    /**
     * Update user.
     * @param id, userDTO
     * @return
     */
    User updateUser (Long id, UserDTOForUpdateAndCreate userDTO);
}


