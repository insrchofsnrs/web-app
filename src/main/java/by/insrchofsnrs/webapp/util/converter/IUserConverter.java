package by.insrchofsnrs.webapp.util.converter;

import by.insrchofsnrs.webapp.dto.UserDTOForUpdateAndCreate;
import by.insrchofsnrs.webapp.pojo.User;

public interface IUserConverter {
    /**
     * Create user from DTO.
     * @param dto
     * @return
     */
    User createUserFromDTO (UserDTOForUpdateAndCreate dto);

    /**
     * Create DTO from user.
     * @param user
     * @return
     */
    UserDTOForUpdateAndCreate createDTOFromUser (User user);


}
