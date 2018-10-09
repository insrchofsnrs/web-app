package by.insrchofsnrs.webapp.util.converter;

import by.insrchofsnrs.webapp.dto.UserDto;
import by.insrchofsnrs.webapp.pojo.User;

public interface IUserConverter {

    /**
     * Create user from DTO.
     * @param dto
     * @return User
     */
    User createUserFromDTO (UserDto dto);

    /**
     * Create DTO from user.
     * @param user
     * @return UserDTO
     */
    UserDto createDTOFromUser (User user);


}
